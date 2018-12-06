package com.chinaredstar.cd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaredstar.cd.dao.UserMapper;
import com.chinaredstar.cd.dao.Users2Mapper;
import com.chinaredstar.cd.pojo.User;
import com.chinaredstar.cd.pojo.Users2;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	Users2Mapper user2Mapper;

	@Override
	public List<User> getUser(int age) {

		return userMapper.getUser(age);
	}

	@Override
	public Users2 selectByPrimaryKey(Integer id) {
		return user2Mapper.selectByPrimaryKey(id);
	}

}
