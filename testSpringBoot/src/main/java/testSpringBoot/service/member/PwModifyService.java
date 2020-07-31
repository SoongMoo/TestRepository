package testSpringBoot.service.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.command.ChangePwdCommand;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.mapper.LoginMapper;
import testSpringBoot.mapper.MemberMapper;
@Component
@Service
@Transactional
public class PwModifyService {
	@Autowired
	LoginMapper loginRepository;
	@Autowired
	MemberMapper memberRepository; 
	/*
	 * @Autowired BCryptPasswordEncoder bcryptPasswordEncoder;
	 */
	public String execute(ChangePwdCommand changePwdCommand,	Model model, HttpSession session)  throws Exception{
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO member = new MemberDTO();
		System.out.println("afsafs : " + authInfo.getId());
		member.setUserId(authInfo.getId());
		member = loginRepository.getSelectUser(member);
		if(/*bcryptPasswordEncoder.matches(*/
				changePwdCommand.getUserPw().equals(member.getUserPw())) {
			return "thymeleaf/member/pwModify_1";
		}else {
			model.addAttribute("valid_Pw", "비밀번호가 틀렸습니다.");
			return "thymeleaf/member/pwModify";
		}
	}
}
