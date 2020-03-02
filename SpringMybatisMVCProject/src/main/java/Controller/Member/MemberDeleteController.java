package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Member.MemberDeleteSevice;

@Controller
public class MemberDeleteController {
	@Autowired
	MemberDeleteSevice memberDeleteSevice;
	@RequestMapping("/edit/memberInfoDel")
	public String memberDelete(@RequestParam(value = "id") String userId) {
		memberDeleteSevice.memberDelete(userId);
		return "redirect:/member/list";  // 회원 삭제
		//return "redirect:/logout"; 탈퇴
	}
	
}
