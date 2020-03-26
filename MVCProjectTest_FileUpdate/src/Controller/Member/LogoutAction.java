package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		Cookie autoCk = new Cookie("auto1","12121212");
		autoCk.setMaxAge(0);
		resp.addCookie(autoCk);
		HttpSession session = req.getSession();
		session.invalidate();
	}
}
