package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Entryfees;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntryfeesDao {
    int deleteByPrimaryKey(Entryfees entryfees);

    int insertentryfees(Entryfees entryfees);

    int insertSelective(Entryfees record);

    List<Entryfees> selectKey();

    int updateByPrimaryKeySelective(Entryfees record);

    int updateByPrimaryKey(Entryfees record);

    int updateapproval(Entryfees entryfees);

    int updateRevokeapproval(Entryfees entryfees);
    //根据id查询
    Entryfees selectByfeeid(Integer feeId);
}