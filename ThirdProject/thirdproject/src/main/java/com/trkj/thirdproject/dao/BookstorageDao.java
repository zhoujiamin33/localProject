package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Bookstorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookstorageDao {
    int deleteByPrimaryKey(Integer mbookstorageId);

    int insert(Bookstorage record);

    int insertSelective(Bookstorage record);

    List<Bookstorage> selectAll();

    int updateByPrimaryKeySelective(Bookstorage record);

    int updateByPrimaryKey(Bookstorage record);

    int addBookstorage(Bookstorage record);
}