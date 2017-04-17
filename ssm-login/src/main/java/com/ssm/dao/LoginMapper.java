package com.ssm.dao;

import com.ssm.domain.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

	Login login(Login loginDomain);
}