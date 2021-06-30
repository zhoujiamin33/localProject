package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesService {
    //查询所有外键表：course
    List<Classes> findAllclass();
    //新增班级
    Classes insert(Classes classes);
    //修改班级
    Classes updateByPrimaryKeySelective(Classes record);
    //班级表中的多条件查询
    List<Classes> selectByContion(@Param("value")String value, @Param("input") String input);
    //   根据课程编号查询所对应的班级
    List<Classes> selectcourseId(Integer courseId);
    // 修改为已开班
    Classes updateClassesOpen1(Classes classes);
    //修改未开班
    Classes updateClassesOpen0(Classes classes);
    //查询所有已开班的班级
    List<Classes> selectOpen();
    //根据班级id查询班级详细课程的进度
    Detailcourse selectDetailCourse(Integer ClassId);
    //    根据id查询班级
    Classes selectById(Integer classesId);
    // 给班级赋值课程详细编号
    Classes updateDetails(Classes classes);
    //根据班级id查询课程详细序列号不存在的课程详细序列号(剩余课程进度)
    List<Detailcourse> selectnotDetails(Integer classesid ,Integer serial);

    List<Detailcourse> selectSerial(Integer classId,String serial);
    //上课、修改课程详细
    Classes classbegin(Classes classes);
    //根据班级和课程详细查询课程详细id
    Detailcourse selectDetailsByserial( Integer classId, String serial);
}
