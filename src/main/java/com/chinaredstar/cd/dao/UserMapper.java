package com.chinaredstar.cd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chinaredstar.cd.pojo.User;

@Mapper
public interface UserMapper {

	@Select("select id,username,age,phone,email from users where age=#{age}")
	List<User> getUser(int age);

}
