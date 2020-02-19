package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.LoginCommand;
import Contoller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

@Service
public class AuthService {
	@Autowired
	private MemberDAO memberDao;
	
	private AuthInfo authInfo;
	public void authenticate(LoginCommand loginCommand,
			HttpSession session, Errors errors) {
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		member.setUserPw(
				Encrypt.getEncryption(loginCommand.getPw()));
		member = memberDao.selectByUserId(member);
		try {
			authInfo = new AuthInfo(member.getUserId(), 
					member.getUserEmail(),member.getUserName(),
					member.getUserPw());
			if(authInfo.getPw().equals(
					Encrypt.getEncryption(loginCommand.getPw()))){
				session.setAttribute("authInfo",authInfo);
			}else {
				System.out.println("비밀번호가 틀립니다.");
				errors.rejectValue("pw","wrong");
			}
		}catch(Exception e) {
			System.out.println("아이디가 없습니다.");
			errors.rejectValue("id1","notId");
		}
	}
}
