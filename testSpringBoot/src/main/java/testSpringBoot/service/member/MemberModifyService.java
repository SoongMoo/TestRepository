package testSpringBoot.service.member;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.command.MemberCommand;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.mapper.LoginMapper;
import testSpringBoot.mapper.MemberMapper;

@Component
@Service
@Transactional
public class MemberModifyService {
	@Autowired
	MemberMapper memberRepository; 
	@Autowired
	LoginMapper loginRepository;

	/*
	 * @Autowired 
	 * BCryptPasswordEncoder bcryptPasswordEncoder;
	 */
	public Integer memberModify(MemberCommand memberCommand,Model model)  throws Exception{
		MemberDTO dto = new MemberDTO();
		dto.setUserAddr(memberCommand.getUserAddr());
		dto.setUserEmail(memberCommand.getUserEmail());
		dto.setUserGender(memberCommand.getUserGender());
		dto.setUserId(memberCommand.getUserId());
		dto.setUserName(memberCommand.getUserName());
		dto.setUserPh1(memberCommand.getUserPh1());
		dto.setUserPh2(memberCommand.getUserPh2());
		MemberDTO member = new MemberDTO();
		System.out.println("memberModify   : " + dto.getUserId());
		member = loginRepository.getSelectUser(dto);
		model.addAttribute("memberCommand" , member);
		if(/*bcryptPasswordEncoder.matches(*/
				memberCommand.getUserPw().equals(member.getUserPw())) {
			dto.setUserPw(member.getUserPw());
			System.out.println(memberCommand.getUserPh1());///////
			return memberRepository.memberUpdate(dto);
		}
		return 0;
	}
}
