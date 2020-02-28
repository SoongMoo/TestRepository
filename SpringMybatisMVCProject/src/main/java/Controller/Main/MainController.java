package Controller.Main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;

@Controller
@RequestMapping("/main")
public class MainController {
	@RequestMapping(method = RequestMethod.GET)
	public String form(LoginCommand loginCommand) {
		System.out.println("aaaa");
		return "main";
	}
}