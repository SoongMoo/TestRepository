package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Member.MemberDetailService;

@Controller
public class MemberDetailController {
	@Autowired
	private MemberDetailService memberDetailService;
	@RequestMapping(value = "/edit/memberInfo/{id}")
	public String memberInfo(@PathVariable(value = "id") String userId, 
			Model model) {
		memberDetailService.memberDetail(userId, model);
		return "member/memberInfo";
	}
	@RequestMapping(value = "/edit/memberModify")
	public String memberModify(@RequestParam(value = "id") String userId,
			Model model) {
		memberDetailService.memberDetail(userId, model);
		return "member/memberModify";
	}
}
