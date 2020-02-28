package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.LoginCommand;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;
@Service
public class AuthService {
	@Autowired
	LoginRepository loginRepository; 
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	private AuthInfo authInfo;
	public void authenticate(LoginCommand loginCommand,
			HttpSession session, Errors errors) {
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		member = loginRepository.selectByUserId(member);
		if(member == null) {
			errors.rejectValue("id1","notId");	
		}else {
			if(bcryptPasswordEncoder.matches(
					loginCommand.getPw() , member.getUserPw())) {
				authInfo = new AuthInfo(member.getUserId(), 
						member.getUserEmail(), member.getUserName(),
						member.getUserPw());
				session.setAttribute("authInfo",authInfo);
			}else {
				errors.rejectValue("pw","wrong");
			}
		}
	}
}
