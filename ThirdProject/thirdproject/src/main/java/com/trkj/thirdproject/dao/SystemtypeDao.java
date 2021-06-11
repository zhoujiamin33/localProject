package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Systemtype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemtypeDao {
    int deleteByPrimaryKey(Integer systemtypeId);

    int insert(Systemtype record);

    int insertSelective(Systemtype record);

    Systemtype selectByPrimaryKey(Integer systemtypeId);

    int updateByPrimaryKeySelective(Systemtype record);

    int updateByPrimaryKey(Systemtype record);
}