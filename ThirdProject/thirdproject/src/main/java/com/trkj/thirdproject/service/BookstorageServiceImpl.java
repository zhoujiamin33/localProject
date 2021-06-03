package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookstorageDao;
import com.trkj.thirdproject.entity.Bookstorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookstorageServiceImpl implements BookstorageService {
    @Autowired
    private BookstorageDao bookstorageDao;
    @Override
    public List<Bookstorage> selectAll() {
        return bookstorageDao.selectAll();
    }

    @Override
    public Bookstorage addBookstorage(Bookstorage bookstorage) {
        bookstorageDao.addBookstorage(bookstorage);
        return bookstorage;
    }
}
