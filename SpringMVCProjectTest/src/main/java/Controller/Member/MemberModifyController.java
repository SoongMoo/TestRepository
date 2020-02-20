package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Service.Member.MemberDetailService;
import Service.Member.MemberModifyService;
import Validator.MemberModifyValidator;

@Controller
public class MemberModifyController {
	@Autowired
	private MemberDetailService memberDetailService;
	@Autowired
	private MemberModifyService memberModifyService;
	@RequestMapping(value="/edit/memberModify")
	public String memberModify(@RequestParam(value = "id") String userId,
			Model model) {
		memberDetailService.memberDetail(userId, model);
		return "member/memberModify";
	}
	@RequestMapping(value="/edit/memberModifyPro")
	public String memberModifyPro(MemberCommand memberCommand,
			Model model, Errors errors) {
		new MemberModifyValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberModify";
		}
		Integer i = memberModifyService.memberModify(
				memberCommand, model);
		System.out.println("aaaaa : " + i);
		if(i == 0) {
			errors.rejectValue("userPw", "badPw");
			return "member/memberModify";
		}
		return "redirect:/edit/memberInfo/"+memberCommand.getUserId();
	}
}
