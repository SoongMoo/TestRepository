package testSpringBoot.service.member;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.domain.MemberDTO;
import testSpringBoot.mapper.LoginMapper;

@Component
@Service
@Transactional
public class MemberDetailService {
	@Autowired
	LoginMapper loginRepository;
	public MemberDTO memberDetail(String userId,Model model) throws Exception{
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member = loginRepository.getSelectUser(member);
		System.out.println("MemberDetailService :" + member.getUserGender());
		model.addAttribute("memberCommand", member);
		return member;
	}
}
