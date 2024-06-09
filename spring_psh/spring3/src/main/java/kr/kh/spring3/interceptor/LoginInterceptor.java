package kr.kh.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring3.model.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler, 
		ModelAndView modelAndView)
		throws Exception {
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		log.info("로그인인터셉터 작동?: "+user);
		if(user != null) {
			request.getSession().setAttribute("user", user);
		}
	}
}