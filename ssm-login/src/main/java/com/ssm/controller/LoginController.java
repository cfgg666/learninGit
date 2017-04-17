package com.ssm.controller;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.domain.Login;
import com.ssm.service.LoginService;

@Controller
@RequestMapping("passport")
public class LoginController{

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("toHome")
	public String toHome(){
		System.out.println("controller处理请求");
		
		return "home";
	}
	
	
	/**
	 * <pre>toLogin(跳转到登录页面)   
	 * 创建人：祝超涵         
	 * 创建时间：2017年4月13日 下午10:18:08    
	 * 修改人：祝超涵       
	 * 修改时间：2017年4月13日 下午10:18:08    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping(value="toLogin")
	public String toLogin(){
		System.out.println("开始请求登录页面");
		return "logins";
	}
	
	/**
	 * <pre>login(登录)   
	 * 创建人：祝超涵         
	 * 创建时间：2017年4月13日 下午10:18:21    
	 * 修改人：祝超涵       
	 * 修改时间：2017年4月13日 下午10:18:21    
	 * 修改备注： 
	 * @param loginDomain
	 * @param volidImgText
	 * @param request
	 * @return</pre>
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public String login(Login loginDomain , String volidImgText ,HttpServletRequest request){
		String n = "1";//失败
		String sessionVolidImg = (String) request.getSession().getAttribute("imgText");
		System.out.println(sessionVolidImg);
		if(volidImgText != null && sessionVolidImg != null && volidImgText.equals(sessionVolidImg)){
			Map<String, Object> map = loginService.login(loginDomain);
			if(map != null && !map.isEmpty()){
				boolean flag = (boolean) map.get("flag");
				if(flag){
					request.getSession().setAttribute("loginInfo", map.get("obj"));
					n = "0";//成功
				}
			}
		}
		
		return n;
	}
	
}
