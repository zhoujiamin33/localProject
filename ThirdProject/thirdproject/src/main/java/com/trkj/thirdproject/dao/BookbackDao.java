package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Bookback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookbackDao {
    int deleteByPrimaryKey(Integer bookbackId);

    int insert(Bookback record);

    int insertSelective(Bookback record);

    Bookback selectByPrimaryKey(Integer bookbackId);

    int updateByPrimaryKeySelective(Bookback record);

    int updateByPrimaryKey(Bookback record);

    List<Bookback> selectAll();
}