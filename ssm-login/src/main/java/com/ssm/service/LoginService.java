package com.ssm.service;

import java.util.Map;

import com.ssm.domain.Login;

public interface LoginService {

	Map<String, Object> login(Login loginDomain);
}