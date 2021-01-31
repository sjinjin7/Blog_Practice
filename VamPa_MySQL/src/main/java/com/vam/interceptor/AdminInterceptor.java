package com.vam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.vam.model.MemberVO;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		int adminCk = 0;
		
		HttpSession session = request.getSession();
		
		MemberVO lvo = (MemberVO) session.getAttribute("member");
		
		if(lvo != null) {
			adminCk = lvo.getAdminCk();	
		}
		
		
		if(lvo == null || adminCk != 1) {	 
			
			response.sendRedirect("/main");
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}	
	
}
