package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		Cookie autoCk = new Cookie("auto1","");
		autoCk.setMaxAge(0);
		response.addCookie(autoCk);
		
		session.invalidate();
	}
}
