package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.MapKey;
import java.util.List;

@Mapper
public interface BookDao {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    //查询所有教材
    List<Book> selectAllBook();
}