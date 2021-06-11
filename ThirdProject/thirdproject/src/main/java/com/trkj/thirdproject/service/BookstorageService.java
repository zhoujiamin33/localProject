package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Bookstorage;

import java.util.List;


public interface BookstorageService {
    List<Bookstorage> selectAll();

    Bookstorage addBookstorage(Bookstorage bookstorage);

    //------------------------------教材表-----------------------------------------------------------------------------
    //查询所有教材
    List<Book> selectAllBook();
}
