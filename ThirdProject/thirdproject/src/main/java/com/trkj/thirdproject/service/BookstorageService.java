package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Bookstorage;

import java.util.List;


public interface BookstorageService {
    List<Bookstorage> selectAll();

    Bookstorage addBookstorage(Bookstorage bookstorage);
}
