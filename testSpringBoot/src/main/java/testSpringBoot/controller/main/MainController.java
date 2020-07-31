package testSpringBoot.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import testSpringBoot.controller.CookieAction;

@Controller
public class MainController {
	@RequestMapping(value="/")
    public String home(Model model,HttpServletRequest request){
		CookieAction action = new CookieAction();
		action.execute(request);
		/* model.addAttribute("loginCommand)", new LoginCommand()); */
        return "thymeleaf/main"; 
    }
}
