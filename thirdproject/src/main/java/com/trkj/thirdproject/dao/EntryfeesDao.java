package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Entryfees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntryfeesDao {
    int deleteByPrimaryKey(Integer feesId);

    int insertentryfees(Entryfees entryfees);

    int insertSelective(Entryfees record);

    List<Entryfees> selectKey();

    int updateByPrimaryKeySelective(Entryfees record);

    int updateByPrimaryKey(Entryfees record);
}