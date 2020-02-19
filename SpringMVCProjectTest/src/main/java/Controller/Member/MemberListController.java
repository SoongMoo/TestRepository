package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Member.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	private MemberListService memberListService;
	
	@RequestMapping("/member/list")
	public String list(Model model) {
		memberListService.memberList(model);
		
		return "member/memberList";
	}
}
