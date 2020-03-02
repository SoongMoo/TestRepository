package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;

@Service
public class MemberDetailService {
	@Autowired
	LoginRepository loginRepository;
	public void memberDetail(String userId,Model model) {
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member = loginRepository.selectByUserId(member);
		model.addAttribute("memberCommand", member);
	}
}
