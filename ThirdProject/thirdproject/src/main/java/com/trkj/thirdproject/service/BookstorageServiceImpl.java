package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookDao;
import com.trkj.thirdproject.dao.BookstorageDao;
import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Bookstorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookstorageServiceImpl implements BookstorageService {
    @Resource
    private BookstorageDao bookstorageDao;
    @Resource
    private BookDao bookDao;

    @Override
    public List<Bookstorage> selectAll() {
        return bookstorageDao.selectAll();
    }

    @Override
    public Bookstorage addBookstorage(Bookstorage bookstorage) {
        bookstorage.setEmpId(1);
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(bookstorage.getBookId());
        //得到此书的进价
        BigDecimal bookjprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= bookjprice.multiply(new BigDecimal(bookstorage.getStoragecount()));
        bookstorage.setTotalprice(allsprice);
        bookstorage.setStoragetime(new Date());
        bookstorageDao.addBookstorage(bookstorage);
        return bookstorage;
    }

    @Override
    public Bookstorage updateByPrimaryKey(Bookstorage bookstorage) {
        bookstorage.setEmpId(1);
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(bookstorage.getBookId());
        //得到此书的进价
        BigDecimal booksprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= booksprice.multiply(new BigDecimal(bookstorage.getStoragecount()));
        bookstorage.setTotalprice(allsprice);
        bookstorageDao.updateByPrimaryKey(bookstorage);
        return bookstorage;
    }

    @Override
    public int deleteByPrimaryKey(int mbookstorageId) {
        bookstorageDao.deleteByPrimaryKey(mbookstorageId);
        return mbookstorageId;
    }
}
