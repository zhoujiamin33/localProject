package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Studentstatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentstatusDao {
    int deleteByPrimaryKey(Integer studentstatusId);

    int insert(Studentstatus record);

    int insertSelective(Studentstatus record);

    Studentstatus selectByPrimaryKey(Integer studentId);//根据学员编号查询学员状态表

    int updateByPrimaryKeySelective(Studentstatus record);
//    停课的状态修改
    int updatestustart(Studentstatus record);

    int updateByPrimaryKey(Studentstatus record);

    //显示所有
    List<Studentstatus> selectstu_class(Integer studentId);
}