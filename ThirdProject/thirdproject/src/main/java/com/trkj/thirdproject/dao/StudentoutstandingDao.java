package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Studentoutstanding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentoutstandingDao {
    int deleteByPrimaryKey(Integer outstandingId);
//新增报班缴费
    int insert(Studentoutstanding record);

    int insertSelective(Studentoutstanding record);
    //查询所有欠费补缴数据
    List<Studentoutstanding> selectoutstanding();

    int updateByPrimaryKeySelective(Studentoutstanding record);

    int updateByPrimaryKey(Studentoutstanding record);

    //查询报班缴费中缴费方式为预交学费的数据
    List<Studentoutstanding> selectoutonentry();

//    多条件查询
    List<Studentoutstanding> selectBycontion(String select,String input);
}
