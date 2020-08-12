package testSpringBoot.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;
import testSpringBoot.command.AuthInfo;

@Slf4j
public class CertificationInterceptor extends  HandlerInterceptorAdapter{
	//컨트롤러(즉 RequestMapping이 선언된 메서드 진입) 실행 직전에 동작.
	// 반환 값이 true일 경우 정상적으로 진행이 되고, false일 경우 실행이 멈춥니다.(컨트롤러 진입을 하지 않음)
	// 전달인자 중 Object handler는 핸들러 매핑이 찾은 컨트롤러 클래스 객체입니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Interceptor > preHandle");
		HttpSession session = request.getSession();
		AuthInfo authInfo =
				(AuthInfo)session.getAttribute("authInfo");
		if(ObjectUtils.isEmpty(authInfo)) { 
			response.sendRedirect("/");
			return false; 
		}//세션 정보가 존재하지 않는 경우
        else {
            return true;
        } //세션에 계정 정보가 존재하는 경우
	}
	// 컨트롤러 진입 후 view가 랜더링 되기 전 수행이 됩니다.
	// 전달인자의 modelAndView을 통해 화면 단에 들어가는 데이터 등의 조작이 가능합니다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("Interceptor > postHandle");
	}
	//컨트롤러 진입 후 view가 정상적으로 랜더링 된 후 제일 마지막에 실행이 되는 메서드입니다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("Interceptor > afterCompletion" );
	}
}
