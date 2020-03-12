package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Service.Member.EmailAllService;

@Controller
@RequestMapping("/memberAllMail")
public class MemberALLMaillingController {
	@Autowired
	EmailAllService emailAllService ;
	@RequestMapping(method = RequestMethod.GET)
	public String maiilling() {
		System.out.print("memberAllMail");
		emailAllService.sendAll();
		return "member/mailSecces";
	}
}
