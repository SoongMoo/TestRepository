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
import testSpringBoot.domain.UserPwChangeDTO;
import testSpringBoot.mapper.LoginMapper;
import testSpringBoot.mapper.MemberMapper;
@Component
@Service
@Transactional
public class PwModifyProService {
	@Autowired
	LoginMapper loginRepository;
	/*
	 * @Autowired BCryptPasswordEncoder bcryptPasswordEncoder;
	 */
	@Autowired
	MemberMapper memberRepository;
	public String execute(Model model, ChangePwdCommand changePwdCommand,HttpSession session)  throws Exception{
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getId();
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member = loginRepository.getSelectUser(member);
		if(/*bcryptPasswordEncoder.matches*/
				changePwdCommand.getUserPw().equals(member.getUserPw())) {
			UserPwChangeDTO dto = new UserPwChangeDTO(
					member.getUserId(),
					member.getUserPw(),/*
					bcryptPasswordEncoder.encode(*/
							changePwdCommand.getNewPw());
			
			
			System.out.println("여기입니까????");
			memberRepository.userPwChange(dto);	
			return "redirect:/member/memberDetail";
		}else {
			model.addAttribute("valid_Pw","현재비밀번호가 맞지 않습니다.");
			return "thymeleaf/member/pwModify_1";
		}
	}
}
