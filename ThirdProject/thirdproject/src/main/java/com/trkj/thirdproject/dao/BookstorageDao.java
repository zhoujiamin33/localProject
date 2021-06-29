package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Deliveryddetails;
import com.trkj.thirdproject.entity.Ideas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookstorageDao {
    int deleteByPrimaryKey(Bookstorage record);

    int insert(Bookstorage record);

    int insertSelective(Bookstorage record);

    List<Bookstorage> selectAll();

    int updateByPrimaryKeySelective(Bookstorage record);

    int updateByPrimaryKey(Bookstorage record);

    int addBookstorage(Bookstorage record);

    List<Bookstorage> selectBookStorage(@Param("value")String value, @Param("input") String input);
}