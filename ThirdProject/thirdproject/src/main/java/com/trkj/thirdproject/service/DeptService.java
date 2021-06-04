package com.trkj.thirdproject.service;



import com.trkj.thirdproject.entity.Dept;

import java.util.List;

public interface DeptService {
//    新增部门
    Dept adadept(Dept dept);
    //修改
    Dept updatedept(Dept dept);
    //删除
    void deldept(Integer deptid);
//    查询所有
    List<Dept> findallDept();

}
