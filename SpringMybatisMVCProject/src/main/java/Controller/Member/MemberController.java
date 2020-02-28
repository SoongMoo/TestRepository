package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Validator.MemberCommandValidator;

@Controller
public class MemberController {
	@Autowired
	private MemberJoinService memberJoinService;
	
	@RequestMapping("/register/agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping(value = "/register/regist",method = RequestMethod.POST)
	public String  memberForm(
			@RequestParam(value="agree",defaultValue ="false") 
			Boolean agree, Model model) {
		if(!agree) {
			return "member/agree";
		}
		model.addAttribute("memberCommand", new MemberCommand());
		return "member/memberForm";
	}
	@RequestMapping(value= "/register/memberJoinAction", 
			method=RequestMethod.POST)
	public String  memberJoin(MemberCommand memberCommand,
			Errors errors, Model model) {
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			model.addAttribute("err", "1");
			return "member/memberForm";
		}
		Integer i = memberJoinService.execute(memberCommand);
		if(i == null) {// 중복 아이디 확인
			errors.rejectValue("userId", "duplicate");
			return "member/memberForm";
		}
		return "member/memberWelcome";
	}
}
