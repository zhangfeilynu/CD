package com.chinaredstar.cd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinaredstar.cd.pojo.User;
import com.chinaredstar.cd.pojo.Users2;
import com.chinaredstar.cd.service.UserService;

/**
 * index
 * @author fei.zhang
 * @date 2018年12月5日
 */

@RestController
public class IndexController {

	@Autowired
	UserService userService;

	@GetMapping("/show")
	public List<User> getUser(int age) {
		return userService.getUser(age);
	}

	@GetMapping("/show2")
	public Users2 getUser2(int id) {
		return userService.selectByPrimaryKey(id);
	}

	@RequestMapping("/index")
	@ResponseBody
	public Map<String, String> index() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "fei.zhang");
		map.put("age", "18");
		return map;
	}

}
