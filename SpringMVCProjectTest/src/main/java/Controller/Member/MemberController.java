package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Service.Member.MemberJoinService;
import Validator.MemberCommandValidator;

@Controller
public class MemberController {
	@Autowired
	private MemberJoinService memberJoinService;
	
	@RequestMapping("/register/agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping("/register/regist")
	public String  memberForm(
			@RequestParam(value="agree", defaultValue = "false") 
			Boolean agree, Model model) {
		if(!agree) {
			return "member/agree";
		}
		model.addAttribute("memberCommand", new MemberCommand());
		return "member/memberForm";
	}
	@RequestMapping(value = "/register/memberJoinAction",
			method = RequestMethod.POST)
	public String  memberJoin(MemberCommand memberCommand,
			Errors errors, Model model) {
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberForm";
		}
		Integer i = 0;
		try {
			i = memberJoinService.execute(memberCommand);
			return "member/memberWelcome";
		}catch(Exception e) {
			e.printStackTrace();
			errors.rejectValue("userId", "duplicate");
			return "member/memberForm";
		}
	}
	@RequestMapping(value = "/register/memberJoinAction",
	method = RequestMethod.GET)
	public String  memberJoinGet() {
		return "redirect:agree";
	}
}
