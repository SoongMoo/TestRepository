package testSpringBoot.service.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.command.LoginCommand;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.mapper.LoginMapper;
@Component
@Service
@Transactional
public class AuthService {
	@Autowired
	LoginMapper loginmapper; 
	@Autowired
	PasswordEncoder passwordEncoder;
	private AuthInfo authInfo;
	public MemberDTO authenticate(LoginCommand loginCommand,	HttpSession session,Model model, HttpServletResponse response) 
			throws Exception{
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		System.out.println("testtest");
		member = loginmapper.getSelectUser(member);
		if(member == null) {
			model.addAttribute("valid_user","아이디가 존재하지 않습니다.");
		}else {
			if(passwordEncoder.matches(loginCommand.getPw(), member.getUserPw())) {
				authInfo = new AuthInfo(member.getUserId(), 
						member.getUserEmail(), member.getUserName(),
						member.getUserPw());
				System.out.println("AuthService : " + authInfo.getId());
				session.setAttribute("authInfo",authInfo);
				Boolean idStore = loginCommand.getIdStore();
				Boolean autologin = loginCommand.getAutoLogin();
				if(autologin != null && autologin == true) {
					Cookie cookie = new Cookie("autoLogin", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if(idStore != null && idStore == true) {
					Cookie cookie = new Cookie("idStore", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("idStore", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}else {
				model.addAttribute("valid_pw", "비밀번호가 틀립니다.");
				member = null;
			}
		}
		return member;
	}
}
