package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Deliveryddetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryddetailsDao {
    int deleteByPrimaryKey(Integer deliveryddetailsId);

    int insert(Deliveryddetails record);

    int insertSelective(Deliveryddetails record);

    List<Deliveryddetails> selectAll();

    int updateByPrimaryKeySelective(Deliveryddetails record);

    int updateByPrimaryKey(Deliveryddetails record);

}