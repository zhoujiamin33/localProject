package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface DeptDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);
    //新增
    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);
    //修改
    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    //    查询所有
    List<Dept> findallDept();
//<!--  删除按钮是修改部门的状态-->
int updatetimeliness(@Param("deletename")String deletename,@Param("deletetime")Date deletetime, @Param("deptId") Integer deptId);

}