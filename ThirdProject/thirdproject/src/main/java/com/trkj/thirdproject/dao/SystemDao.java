package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.System;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemDao {
    int deleteByPrimaryKey(Integer systemId);

    int insert(System record);

    int insertSelective(System record);

    System selectByPrimaryKey(Integer systemId);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);
    List<System> findAllSystem();
}