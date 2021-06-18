package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchedulingDao {
    int deleteByPrimaryKey(Integer schedulingId);
    //新增排课
    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer schedulingId);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);
}