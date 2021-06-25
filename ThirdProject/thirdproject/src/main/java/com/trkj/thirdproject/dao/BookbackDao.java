package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Bookback;
import com.trkj.thirdproject.entity.Bookstorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<Bookback> selectBookBack(@Param("value")String value, @Param("input") String input);
}