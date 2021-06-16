package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface StudentDao {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);


    Student selectByPrimaryKey(Integer studentId);


    int updateByPrimaryKey(Student record);
    List<Student> selectAllstudent();
    //新增
    int addstudent(Student student);
    //删除
    int delstuTimeness(@Param("deletename") String deletename, @Param("deletetime")  Date deletetime, @Param("studentId")  Integer studentId);
//    void deletestudent(Integer studentId);
//    修改
    int updatestudent(Student student);
    //模糊查询根据姓名和电话
    List<Student> slectName(@Param("index") String index,@Param("value") String value);
    //<!--  根据学员表里的班级id查询班级信息：如果没有分班呢？班级记录表李会显示请选择班级-->
//    List<Student> selectAllclass();
//修改班级编号
    Student AddclassesId(@Param("classesId") Integer classesId,@Param("studentId") Integer studentId);


}