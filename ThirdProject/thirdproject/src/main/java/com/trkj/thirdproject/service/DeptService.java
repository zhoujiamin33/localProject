package com.trkj.thirdproject.service;



import com.trkj.thirdproject.entity.Dept;

import java.util.Date;
import java.util.List;

public interface DeptService {
//    新增部门
    Dept adadept(Dept dept);
    //修改
    Dept updatedept(Dept dept);
    //删除
    int updatetimeliness(String deletename, Date deletetime, Integer deptId);

//    查询所有
    List<Dept> findallDept();

}
