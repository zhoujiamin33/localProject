package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.entity.Studentstatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentstatusDao {
    int deleteByPrimaryKey(Integer studentstatusId);

    int insert(Studentstatus record);

    int insertSelective(Studentstatus record);

    List<Studentstatus> selectByPrimaryKey(Integer studentId);//根据学员编号查询学员状态表
    //    停课的状态修改
    int updateByPrimaryKeySelective(Studentstatus record);

    int updatestustart(Studentstatus record);

    int updateByPrimaryKey(Studentstatus record);

    //显示所有
    List<Studentstatus> selectstu_class(Integer studentId);
    //修改班级编号
    Studentstatus AddclassesId(@Param("classesId") Integer classesId, @Param("studentId") Integer studentId);
//    根据状态编号查询
    Studentstatus selectByPrimaryKeyId(Integer studentstatusId);
}