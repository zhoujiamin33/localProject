package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Memorandumattachment;
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


//    学员交接表的修改
int updateByPrimaryKeySelective(Memorandumattachment record);
//查查询所有（咨询登记）
    List<Memorandumattachment> selectregister(Integer memorandumattachmentid);
//    新增学员交接
int insertSelective(Memorandumattachment record);
}
