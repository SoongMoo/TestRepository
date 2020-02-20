package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Service.Member.PasswordModifyService;
import Validator.ChangePwdCommandValidator;

@Controller
public class PwModifyProController {
	@Autowired
	private PasswordModifyService passwordModifyService;
	
	@RequestMapping(value = "/edit/pwModifyPro", 
			method = RequestMethod.POST)
	public String pwModifyPro(ChangePwdCommand changePwdCommand,
			Errors errors) {
		System.out.println("pwModifyPro : " + changePwdCommand.getUserId());
		new ChangePwdCommandValidator().validate(changePwdCommand, 
				errors);
		if(errors.hasErrors()) {
			return "member/pwModify_1";
		}
		Integer i = 
				passwordModifyService.updatePassword(changePwdCommand);
		if(i == 0) {
			errors.rejectValue("pw","notCurrent");
			return "member/pwModify_1";
		}
		return "redirect:/main";
	}
}
