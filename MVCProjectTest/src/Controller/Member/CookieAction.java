package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		Cookie [] cookies = request.getCookies();
		HttpSession session = request.getSession();
		if(cookies != null && cookies.length > 0) {
			for(Cookie c : cookies) {
				if(c.getName().equals("id")) {
					request.setAttribute("isId", c.getValue());
					request.setAttribute("isCheck", true);
				}
				if(c.getName().equals("auto1")) {
					// �ڵ� �α����� �Ͽ� �α��� ���¸� �����ϱ� ���� session�� ����
					session.setAttribute("memId", c.getValue());
				}
			}
		}
	}
}
