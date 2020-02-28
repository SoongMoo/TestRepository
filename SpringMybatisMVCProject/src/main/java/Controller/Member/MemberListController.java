package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Member.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	MemberListService memberListService;
	@RequestMapping("/member/list")
	public String memberlist(Model model, 
			@RequestParam(value = "page" , defaultValue = "1") 
			Integer page)  {
		memberListService.memberList(model,page);
		return "member/memberList";
	}
}
