package com.ssm.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.domain.Login;


public class SelfInterceptor implements HandlerInterceptor{

//	最后执行  afterCompletion：   preHandle执行后返回值为true时，springmvc装载视图完成后    执行      
//	当前方法一般用于资源回收
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion1");
		
	}

//	postHandle:preHandle执行后返回值为true时，springmvc装载视图完成前（跳转到视图层之前） 执行
//	一般用于对        向页面传递的数据进行处理
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle1");
		
	}

	//请求执行前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("preHandle1");
		HttpSession session = request.getSession();
		Login loginInfo= (Login) session.getAttribute("loginInfo");
		 if(loginInfo!=null){
			 return true;
		 }else{
			 request.getRequestDispatcher("/passport/toLogin.do").forward(request, response);
			 
		 }
		System.out.println(loginInfo);
		return false;


	}

}
