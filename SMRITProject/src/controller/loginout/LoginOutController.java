package controller.loginout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutController  extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		if(command.equals("/main.main")) {
			CookieAction action = new CookieAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/main/main.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/login/loginPro.main")) {
			LoginProAction action = new LoginProAction();
			action.execute(request, response);
		}else if(command.equals("/login/logOutPro.main")) {
			Cookie cookie = new Cookie("autoLogin", "");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("../main.main");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
