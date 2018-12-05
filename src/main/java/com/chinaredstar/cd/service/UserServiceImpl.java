package com.chinaredstar.cd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaredstar.cd.dao.UserMapper;
import com.chinaredstar.cd.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> getUser(int age) {

		return userMapper.getUser(age);
	}

}
