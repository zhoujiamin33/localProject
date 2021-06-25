package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Scheduling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchedulingDao {
    int deleteByPrimaryKey(Integer schedulingId);
    //新增排课
    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer schedulingId);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);
    //查询所有排课
    List<Scheduling> selectAllScheduling();
    //查询这一时间段选择的教师、教室有没有被占用
    Scheduling selectremove( @Param("periodId") int periodId, @Param("classroomName") String classroomName, @Param("empName") String empName);
}