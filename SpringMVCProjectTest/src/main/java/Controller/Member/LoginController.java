package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;
import Service.Member.AuthService;
import Validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "redirect:/main";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand,Errors errors,
			HttpSession session) {
		new LoginCommandValidator().validate(loginCommand, errors);
		authService.authenticate(loginCommand, session, errors);
		if (errors.hasErrors()) {
			return "main";
		}
		return "redirect:/main";
	}
	
}
