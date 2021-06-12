package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassesDao {
    int deleteByPrimaryKey(Integer classesId);
    //新增班级
    int insert(Classes classes);

    Classes insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classesId);
    //修改班级
    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    //查询所有外键表：course
   List<Classes> findAllclass();
   //班级表中的多条件查询
   List<Classes> selectByContion(@Param("value")String value,@Param("input") String input);
}