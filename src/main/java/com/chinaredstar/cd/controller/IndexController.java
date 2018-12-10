package com.chinaredstar.cd.controller;

import java.math.BigDecimal;
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
import com.chinaredstar.cd.pojo.Userposition;
import com.chinaredstar.cd.pojo.Users2;
import com.chinaredstar.cd.service.UserPositionService;
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

	@Autowired
	UserPositionService userPositionService;

	@GetMapping("/show")
	public List<User> getUser(int age) {
		return userService.getUser(age);
	}

	@GetMapping("/show2")
	public Users2 getUser2(int id) {
		return userService.selectByPrimaryKey(id);
	}

	/**
	 * 附近的地点
	 * @param radii 半径距离(单位km)
	 * @param lon 经度
	 * @param lat 纬度
	 * @return
	 */
	@GetMapping("/pos")
	public List<Userposition> getVicinity(double radii, double lon, double lat) {
		double r = 6371;// 地球半径千米
		double dlng = 2 * Math.asin(Math.asin(radii / (2 * r)) / Math.cos(lat * Math.PI / 180));
		dlng = dlng * 180 / Math.PI;// 角度转为弧度
		double dlat = radii / r;
		dlat = dlat * 180 / Math.PI;
		double minlat = lat - dlat;
		double maxlat = lat + dlat;
		double minlng = lon - dlng;
		double maxlng = lon + dlng;
		return userPositionService.getVicinity(BigDecimal.valueOf(minlng), BigDecimal.valueOf(maxlng),
				BigDecimal.valueOf(minlat), BigDecimal.valueOf(maxlat));
	}

	/**
	* 附近的人排序
	* @param lon 经度
	* @param lat 纬度
	* @return
	*/
	@GetMapping("/possort")
	public List<Userposition> getVicinitySort(double lon, double lat) {

		return userPositionService.getVicinitySort(BigDecimal.valueOf(lon), BigDecimal.valueOf(lat));
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
