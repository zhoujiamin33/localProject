package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Systemselect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper

public interface SystemselectDao {
    int deleteByPrimaryKey(Integer systemselectId);

    int insert(@Param("systemId")int systemId, @Param("empId")int empId);

    int insertSelective(Systemselect record);

    Systemselect selectByPrimaryKey(Integer systemselectId);

    int updateByPrimaryKeySelective(Systemselect record);

    int updateByPrimaryKey(Systemselect record);

}