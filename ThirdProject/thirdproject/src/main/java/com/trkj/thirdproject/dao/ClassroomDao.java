package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassroomDao {
    int deleteByPrimaryKey(Integer classroomId);

    int insert(Classroom classroom);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer classroomId);

    int updateByKey(Classroom classroom);

    int updateByPrimaryKey(Classroom record);

    List<Classroom> findAllRoom();

}