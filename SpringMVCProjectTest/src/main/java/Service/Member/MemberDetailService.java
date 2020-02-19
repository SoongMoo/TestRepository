package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;
@Service
public class MemberDetailService {
	@Autowired
	private MemberDAO memberDAO;
	public void memberDetail(String userId, Model model) {
		MemberDTO member = new  MemberDTO();
		member.setUserId(userId);
		member = memberDAO.selectByUserId(member);
		model.addAttribute("member", member);
	}
}
