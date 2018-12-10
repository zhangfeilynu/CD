package com.chinaredstar.cd.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaredstar.cd.pojo.Userposition;
import com.chinaredstar.cd.service.UserPositionService;

@Controller
public class UserPositionController {

	@Autowired
	UserPositionService userPositionService;

	@RequestMapping(value = "/mynearby")
	public String myNearby(Model model, double lon, double lat) {
		double r = 6371;// 地球半径千米
		double dis = 2; // 半径 单位:km
		double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(lat * Math.PI / 180));
		dlng = dlng * 180 / Math.PI;// 角度转为弧度
		double dlat = dis / r;
		dlat = dlat * 180 / Math.PI;
		double minlat = lat - dlat;
		double maxlat = lat + dlat;
		double minlng = lon - dlng;
		double maxlng = lon + dlng;

		List<Userposition> list = userPositionService.getVicinity(BigDecimal.valueOf(minlng),
				BigDecimal.valueOf(maxlng), BigDecimal.valueOf(minlat), BigDecimal.valueOf(maxlat));
		model.addAttribute("myinfo", list);
		return "mynearby";
	}

}
