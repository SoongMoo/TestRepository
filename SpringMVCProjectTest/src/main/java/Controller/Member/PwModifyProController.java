package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Validator.ChangePwdCommandValidator;

@Controller
public class PwModifyProController {

	
	@RequestMapping(value = "/edit/pwModifyPro", 
			method = RequestMethod.POST)
	public String pwModifyPro(ChangePwdCommand changePwdCommand,
			Errors errors) {
		new ChangePwdCommandValidator().validate(changePwdCommand, 
				errors);
		if(errors.hasErrors()) {
			return "member/pwModify_1";
		}

		return "redirect:/main";
	}
}
