package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentService {
    //查询学员编号
//    Studentstatus selecttudentstsatus(Integer studentId);
    Student selectstudentId(Integer studentId);
    //    新增
    Student addstudent(Student student);
    //删除
    Student delstuTimeness(Student student);
    //    修改
    Student updatestudent(Student student);
    //模糊查询根据姓名和电话
    List<Student> slectName(String index,String value);
//    List<Student> slectPhone(String studentPhone);


//    //查询所有值（生源渠道）
//    List<Source> selectalls();

    //查询所有外键表：course（课程表）

    //    学员交接表的修改
    int updateByPrimaryKeySelective(Memorandumattachment record);
    //在学员交接表查查询所有（咨询登记）
    List<Memorandumattachment> selectregister();
    //    新增学员交接
    int insertSelective(Memorandumattachment record);

    //学员表中查看详情获取课程顾问：根据咨询编号
    Register selectRegister(Integer RegisterId);

    //<!--  根据学员表里的班级id查询班级信息：如果没有分班呢？班级记录表李会显示请选择班级-->
    Classes selectByPrimaryKey(Integer classesId);
    //<!--  根据学员表里的班级id查询班级信息：如果没有分班呢？班级记录表李会显示请选择班级-->
//    查看所有
    List<Student> selectAllstudent();

    //    根据咨询编号查看交接内容
    Memorandumattachment selectregisterID(Integer registerId);

    //修改班级编号
    int AddclassesId(Integer classesId,Integer studentId);
//    修改学员审核的状态
Student updatestudentstate(Student student);
    //根据班级id查询学员信息
    List<Student> selectByClass(Integer classesId);
}
