package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Member.MemberDetailService;

@Controller
public class MemberInfoController {
	@Autowired
	private MemberDetailService memberDetailService;
	@RequestMapping("/edit/memberInfo/{ccc}")
	public String memberInfo(@PathVariable("ccc") String userId ,
			Model model) {
		try {
			memberDetailService.memberDetail(userId, model);
		}catch(Exception e) {
			return "redirect:/member/memberList";
		}
		return "member/memberInfo";
	}
}
