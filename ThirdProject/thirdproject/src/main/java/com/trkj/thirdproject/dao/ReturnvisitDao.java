package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.entity.Returnvisit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReturnvisitDao {
    int deleteByPrimaryKey(Integer returnvisitId);

    int inserRreturnvisit(Returnvisit record);

    int insertSelective(Returnvisit record);

    List<Returnvisit> selectReturnvisit(Integer registerId);

    //回访批量删除
    int delstuRetTime(@Param("returnvisitId" ) int ReturnVisit_Id);


    int updateByPrimaryKeySelective(Returnvisit record);

    int updateByPrimaryKey(Returnvisit record);

    //回访次数
    List<Returnvisit> Numberofreturnvisits();
}