package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKey(Dept record);
    //新增
    int adadept(Dept dept);
//    查询所有
    List<Dept> findallDept();
    //修改
    int updatedept(Dept dept);

}