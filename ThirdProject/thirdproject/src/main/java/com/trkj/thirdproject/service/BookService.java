package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> selectAllBook();

    Book addBook(Book book);

    Book selectByPrimaryKey(Integer bookId);

    Book selectbooksprice(String bookname);

    Book updateBook(Book book);
}
