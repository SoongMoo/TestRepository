package testSpringBoot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import testSpringBoot.Interceptor.CertificationInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new CertificationInterceptor())
				//적용할 url 패턴을 설정합니다.
        		.addPathPatterns("/**/*")
        		// 인터셉터를 제외할 url 패턴을 등록하는 메서드로써 해당 url로 접근 시에는 인터셉터를 적용하지 않게 됩니다.
        		.excludePathPatterns("/register/**/")
                .excludePathPatterns("/login")
                .excludePathPatterns("/chatting"); //로그인 쪽은 예외처리를 한다.
	}
}
