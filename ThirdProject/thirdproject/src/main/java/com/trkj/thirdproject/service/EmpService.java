package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Emp;

import java.util.Date;
import java.util.List;

public interface EmpService {
    //新增
    Emp insert(Emp record);
    //查询
    List<Emp> selectAllEmp();
//    删除
    void delectEmp(Integer EmpId);
    //修改
    Emp updateEmp(Emp emp);
    //模糊查询
    List<Emp> findalls(String index,String value);
    //批量删除
    void delstuTimeness( String leavename, Date leavetime,List<Integer> empId);

    //启动或禁用
    void updatestate(Integer workersstate,List<Integer>  empId);
}
