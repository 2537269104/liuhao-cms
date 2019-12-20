package com.liuhao.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 
 * @author 刘浩
 * @Title: AuthUserInterceptor.java 
 * @Package com.liuhao.cms.common 
 * @Description: 前台的拦截器  
 * @date 2019年12月17日 下午3:16:58
 */
public class AuthUserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userInfo = request.getSession().getAttribute(CmsConstant.UserSessionKey);
		if(userInfo!=null) {
			return true;
		}
	    response.sendRedirect("/user/login");
		return false;
	}

}
