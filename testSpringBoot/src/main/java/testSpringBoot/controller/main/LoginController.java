package testSpringBoot.controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import testSpringBoot.command.LoginCommand;
import testSpringBoot.controller.CookieAction;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.service.login.AuthService;

@Controller
@RequestMapping()
public class LoginController {
	@Autowired
	AuthService authService;
	
	@ModelAttribute
	LoginCommand setLoginCommand() {
        return new LoginCommand();
    }
	@RequestMapping(value = "login" , method = RequestMethod.GET)
	public String form(LoginCommand loginCommand) {
		return "redirect:/";
	}
	@RequestMapping(value = "login" , method = RequestMethod.POST)
	public String submit(@Validated LoginCommand loginCommand,BindingResult result,HttpSession session,HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception{
		System.out.println("LoginController : " + loginCommand.getId1());
		 if (result.hasErrors()) {
			System.out.println("aaaaa");
			CookieAction action = new CookieAction();
			action.execute(request);
			return "thymeleaf/main";
		}
		MemberDTO member = authService.authenticate(loginCommand,session,model, response);
		if (member == null) {
			CookieAction action = new CookieAction();
			action.execute(request);
			return "thymeleaf/main";
		}
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session,
			HttpServletResponse response) {
		Cookie autoLoginCookie = new Cookie("autoLogin","");
		autoLoginCookie.setMaxAge(0);
		response.addCookie(autoLoginCookie);
		session.invalidate();
		return "redirect:/";
	}
}
