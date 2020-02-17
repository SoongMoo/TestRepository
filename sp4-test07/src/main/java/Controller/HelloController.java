package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String helloTest(Model model,
			@RequestParam(value="name", required=false) int a,
			@RequestParam(value="nai", required=false) int b) {
		model.addAttribute("test", a);
		return "hello";
	}
}
