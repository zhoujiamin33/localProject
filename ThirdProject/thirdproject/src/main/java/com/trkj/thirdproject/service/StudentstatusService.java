package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.entity.Studentstatus;

import java.util.List;

public interface StudentstatusService {
    //显示所有
    List<Studentstatus> selectstu_class(Integer studentId);
//    新增
    Studentstatus AddStudentstatus(Studentstatus studentstatus);
//    停课后；学员状态表中显示已停课
Studentstatus updatestustart(Studentstatus record);
//查询学员状态表stu
    Studentstatus selectByPrimaryKey(Integer studentId);
    //修改班级编号
    Studentstatus updateByPrimaryKeySelective(Studentstatus record);
//    Studentstatus AddclassesId(Integer classesId, Integer studentId);
}
