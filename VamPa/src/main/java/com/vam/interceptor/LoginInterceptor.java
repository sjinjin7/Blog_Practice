package com.vam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//System.out.println("로그인  인터셉터 적용");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member") != null) {
			
			session.invalidate();
			
		}
			
		return true;
	}
	
}
