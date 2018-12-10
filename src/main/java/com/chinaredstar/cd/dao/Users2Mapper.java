package com.chinaredstar.cd.dao;

import com.chinaredstar.cd.pojo.Users2;

public interface Users2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users2 record);

    int insertSelective(Users2 record);

    Users2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users2 record);

    int updateByPrimaryKey(Users2 record);
}