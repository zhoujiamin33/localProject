package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.DeptDao;
import com.trkj.thirdproject.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    //新增部门
    @Override
    public Dept adadept(Dept dept) {
        deptDao.adadept(dept);
        return dept;
    }
    //修改
    @Override
    public Dept updatedept(Dept dept) {
        deptDao.updatedept(dept);
        return dept;
    }

    //删除
    @Override
    public void deldept(Integer deptid) {
       deptDao.deleteByPrimaryKey(deptid);
    }

    @Override
    public List<Dept> findallDept() {
        return deptDao.findallDept();
    }


}
