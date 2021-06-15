package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Bookdelivery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookdeliveryDao {
    int deleteByPrimaryKey(Integer bookdeliveryId);

    int insert(Bookdelivery record);

    int insertSelective(Bookdelivery record);

    Bookdelivery selectByPrimaryKey(Integer bookdeliveryId);

    int updateByPrimaryKeySelective(Bookdelivery record);

    int updateByPrimaryKey(Bookdelivery record);
}