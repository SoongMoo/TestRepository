package controller.loginout;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CookieAction {
	public void execute(HttpServletRequest request) {
		Cookie [] cookies = request.getCookies();
		HttpSession session = request.getSession();
		if(cookies != null && cookies.length > 0) {
			for(Cookie c: cookies) {
				if(c.getName().startsWith("id")) {
					request.setAttribute("isId", c.getValue());
				}
				if(c.getName().equals("autoLogin")) {
					session.setAttribute("logId", c.getValue());
				}
			}
		}
	}
}
