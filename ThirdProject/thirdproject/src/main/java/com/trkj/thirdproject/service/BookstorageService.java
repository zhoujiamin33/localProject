package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Bookstorage;

import java.util.List;

public interface BookstorageService {
    List<Bookstorage> selectAll();

    Bookstorage addBookstorage(Bookstorage bookstorage);

    Bookstorage updateByPrimaryKey(Bookstorage bookstorage);

    int deleteByPrimaryKey(int mbookstorageId);
}
