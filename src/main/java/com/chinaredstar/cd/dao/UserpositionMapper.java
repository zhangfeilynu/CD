package com.chinaredstar.cd.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinaredstar.cd.pojo.Userposition;

public interface UserpositionMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Userposition record);

	int insertSelective(Userposition record);

	Userposition selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Userposition record);

	int updateByPrimaryKey(Userposition record);

	// 附近的地点
	List<Userposition> getVicinity(@Param("minlng") BigDecimal minlng, @Param("maxlng") BigDecimal maxlng,
			@Param("minlat") BigDecimal minlat, @Param("maxlat") BigDecimal maxlat);

	// 按照距离远近
	List<Userposition> getVicinitySort(@Param("longitude") BigDecimal longitude,
			@Param("latitude") BigDecimal latitude);
}