package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Bookstorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    int deleteByPrimaryKey(Integer bookId);

    //int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int addBook(Book book);

    List<Book> selectAllBook();

    Book selectbooksprice(String bookname);

    int updateBook(Book record);
}