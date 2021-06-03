package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Emp;

public interface EmpDao {
    int deleteByPrimaryKey(Integer empId);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}