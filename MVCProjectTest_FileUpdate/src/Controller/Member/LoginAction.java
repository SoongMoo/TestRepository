package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;

public class LoginAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		String userId = req.getParameter("id1");
		String userPw = Encrypt.getEncryption(req.getParameter("pw"));
		String idStore =  req.getParameter("idStore");
		String auto1 = req.getParameter("autoLogin");
		MemberDAO dao = new MemberDAO();
		Integer result = dao.userCheck(userId,userPw);
		if(result == 1) {
			session.setAttribute("memId", userId);
			session.removeAttribute("failPw");
			session.removeAttribute("failId");
			if(auto1 != null && auto1.equals("auto")) {
				Cookie autoCk = new Cookie("auto1",userId);
				autoCk.setMaxAge(60*60*24);
				resp.addCookie(autoCk);
			}
			if(idStore != null && idStore.equals("store")) {
				Cookie cookie = new Cookie("id",userId );
				cookie.setMaxAge(60*60*24*30);
				resp.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("id",userId );
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
				session.removeAttribute("isId");
				session.removeAttribute("cookieId");
			}
		}else if(result == 0 ){
			session.setAttribute("failPw", "비밀번호가 틀렸습니다.");
			session.removeAttribute("failId");
		}else if(result == -1 ){
			session.setAttribute("failId", "아이디가 존재하지 않습니다.");
			session.removeAttribute("failPw");
		}
		
	}
}
