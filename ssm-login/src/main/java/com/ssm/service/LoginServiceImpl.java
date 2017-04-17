package com.ssm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.LoginMapper;
import com.ssm.domain.Login;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public Map<String, Object> login(Login loginDomain) {
		Map<String, Object> map = new HashMap<>();
		boolean flag = false;
		loginDomain = loginMapper.login(loginDomain);
		if(loginDomain != null){
			map.put("obj", loginDomain);
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}

}
