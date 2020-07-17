package controller.loginout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;

public class LoginProAction {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		MemberDAO dao = new MemberDAO();
		Integer i = dao.memberLoginCk(userId, userPw);
		
		HttpSession session = request.getSession();
		if( i >= 1) {
			session.setAttribute("logId", userId);
			String idStore = request.getParameter("idStore");
			String autologin = request.getParameter("autologin");
			if(autologin != null && autologin.equals("auto")) {
				Cookie cookie = new Cookie("autoLogin", userId);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
			}
			if(idStore != null && idStore.equals("store")) {
				Cookie cookie = new Cookie("idStore", userId);
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("idStore", userId);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			try {
				response.sendRedirect("../main.main");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.print("<script>");
				if(i == 0) {
					out.print("alert('비밀번호가 틀렸습니다.');");
				}else if(i == -1) {
					out.print("alert('아이디가 틀렸습니다.');");
				}
				out.print("location.href='../main.main';");
				out.print("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
