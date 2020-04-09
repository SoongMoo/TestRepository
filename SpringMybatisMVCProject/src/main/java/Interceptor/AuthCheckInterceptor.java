package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import Model.DTO.AuthInfo;
                                  
public class AuthCheckInterceptor 
	extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/main");
		return false;
	}
}
