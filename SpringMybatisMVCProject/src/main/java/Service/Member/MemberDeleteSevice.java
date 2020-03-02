package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.DTO.MemberDTO;
import Repository.Member.MemberDMLRepository;

@Service
public class MemberDeleteSevice {
	@Autowired
	MemberDMLRepository memberDMLRepository;
	public void memberDelete(String userId) {
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		memberDMLRepository.memberDelete(member);
	}
}
