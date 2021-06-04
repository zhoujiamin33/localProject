package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Source;
import com.trkj.thirdproject.entity.Student;

import java.util.Date;
import java.util.List;

public interface StudentService {
//    查看所有
    List<Student> selectAllstudent();
//    新增
Student addstudent(Student student);
    //删除
    void delstuTimeness(String deletename, Date deletetime, List<Integer>  studentId);
    //    修改
    Student updatestudent(Student student);
    //模糊查询根据姓名和电话
    List<Student> slectNameAndPhone(String Name, String Phone);


//    //查询所有值（生源渠道）
//    List<Source> selectalls();
}
