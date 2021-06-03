package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Semester;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SemesterDao {
    int deleteByPrimaryKey(Integer semesterId);

    int insert(Semester record);

    int insertSelective(Semester record);

    Semester selectByPrimaryKey(Integer semesterId);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);

    List<Semester> selectAIISemesters();
}