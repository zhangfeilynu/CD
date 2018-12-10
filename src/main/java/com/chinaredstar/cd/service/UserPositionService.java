package com.chinaredstar.cd.service;

import java.math.BigDecimal;
import java.util.List;

import com.chinaredstar.cd.pojo.Userposition;

public interface UserPositionService {

	List<Userposition> getVicinity(BigDecimal minlng, BigDecimal maxlng, BigDecimal minlat, BigDecimal maxlat);

	List<Userposition> getVicinitySort(BigDecimal longitude, BigDecimal latitude);

}
