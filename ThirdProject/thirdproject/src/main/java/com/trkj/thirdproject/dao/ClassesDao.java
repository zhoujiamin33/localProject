package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
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
//   根据课程编号查询所对应的班级
    Classes selectcourseId(Integer courseId);
    // 修改为已开班
    int updateClassesOpen1(Classes classes);
    //修改未开班
    int updateClassesOpen0(Classes classes);
    //查询所有已开班的班级
    List<Classes> selectOpen();
    //根据班级id查询班级详细课程的进度
    List<Detailcourse> selectDetailCourse();
//    根据id查询班级
    Classes selectById(Integer classesId);
    //给班级赋值课程详细编号
    int updateDetails(Classes classes);
    //根据班级id查询课程详细序列号不存在的课程详细序列号(剩余课程进度)
    List<Detailcourse> selectnotDetails(@Param("classesId") Integer classesid , @Param("serial") Integer serial);
}