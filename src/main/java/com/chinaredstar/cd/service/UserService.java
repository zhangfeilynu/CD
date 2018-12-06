package com.chinaredstar.cd.service;

import java.util.List;

import com.chinaredstar.cd.pojo.User;
import com.chinaredstar.cd.pojo.Users2;

public interface UserService {

	List<User> getUser(int age);

	Users2 selectByPrimaryKey(Integer id);

}
