package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CookieAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		Cookie [] cookies = req.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie c : cookies){
				if(c.getName().equals("id")){
					session.setAttribute("isId", true);
					session.setAttribute("cookieId", c.getValue());
				}else if(c.getName().equals("auto1")){
					session.setAttribute("memId", c.getValue());
				}
			}
		}
	}
}
