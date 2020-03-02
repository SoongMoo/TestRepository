package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.MemberCommand;
import Service.Member.MemberModifyService;

@Controller
public class MemberModifyController {
	@Autowired
	MemberModifyService memberModifyService; 
	@RequestMapping(value = "/edit/memberModifyPro", method = RequestMethod.POST)
	public String membermodify(MemberCommand memberCommand, 
			Model model,Errors errors) {
		Integer i = memberModifyService.memberModify(memberCommand, model);
		if(i > 0) {
			return "redirect:/edit/memberInfo/"+memberCommand.getUserId();
		}else {
			errors.rejectValue("userPw", "badPw");
			return "member/memberModify";
		}
	}
}
