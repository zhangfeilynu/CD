package com.chinaredstar.cd.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaredstar.cd.dao.UserpositionMapper;
import com.chinaredstar.cd.pojo.Userposition;

@Service
public class UserPositionServiceImpl implements UserPositionService {

	@Autowired
	UserpositionMapper userpositionMapper;

	@Override
	public List<Userposition> getVicinity(BigDecimal minlng, BigDecimal maxlng, BigDecimal minlat, BigDecimal maxlat) {

		return userpositionMapper.getVicinity(minlng, maxlng, minlat, maxlat);
	}

	@Override
	public List<Userposition> getVicinitySort(BigDecimal longitude, BigDecimal latitude) {

		return userpositionMapper.getVicinitySort(longitude, latitude);

	}

}
