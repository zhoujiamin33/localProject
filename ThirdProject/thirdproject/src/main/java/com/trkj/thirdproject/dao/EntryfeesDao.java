package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Entryfees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.exception.DataException;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
}