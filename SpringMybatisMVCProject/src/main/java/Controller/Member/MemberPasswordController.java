package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.MemberCommand;
import Service.Member.PwModifyService;

@Controller
@RequestMapping( value = "/edit/changePassword")
public class MemberPasswordController {
	@Autowired
	PwModifyService  pwModifyService; 
	@RequestMapping(method = RequestMethod.GET)
	public String form(MemberCommand memberCommand) {
		return "member/pwModify";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String passForm(MemberCommand memberCommand,Errors errors,
			Model model) {
		return pwModifyService.execute(memberCommand, errors,model);
	}
}
