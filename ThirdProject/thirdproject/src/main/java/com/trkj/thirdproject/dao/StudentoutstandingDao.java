package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Studentoutstanding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentoutstandingDao {
    int deleteByPrimaryKey(Integer outstandingId);

    int insert(Studentoutstanding record);

    int insertSelective(Studentoutstanding record);

    Studentoutstanding selectByPrimaryKey(Integer outstandingId);

    int updateByPrimaryKeySelective(Studentoutstanding record);

    int updateByPrimaryKey(Studentoutstanding record);

    //查询报班缴费中缴费方式为预交学费的数据
    List<Studentoutstanding> selectoutonentry();
}