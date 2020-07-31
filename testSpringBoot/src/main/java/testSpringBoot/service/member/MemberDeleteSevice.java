package testSpringBoot.service.member;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testSpringBoot.domain.MemberDTO;
import testSpringBoot.mapper.MemberMapper;
@Component
@Service
@Transactional
public class MemberDeleteSevice {
	@Autowired
	MemberMapper memberRepository;
	public void memberDelete(String userId) throws Exception{
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		memberRepository.memberDelete(member);
	}
	
	
	public Integer memberInfoDelete(String userId, String userPw) throws Exception{
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member.setUserPw(userPw);
		return memberRepository.memberDelete(member);
	}
}
