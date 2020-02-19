package Service.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberListService {
	@Autowired
	private MemberDAO memberDAO;
	public void memberList(Model model) {
		List<MemberDTO> members = memberDAO.selectList();
		if(members != null) {
			model.addAttribute("memberList", members);
			model.addAttribute("count", memberDAO.count());
		}
	}
}
