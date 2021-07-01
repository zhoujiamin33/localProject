package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookDao;
import com.trkj.thirdproject.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;


    @Override
    public List<Book> selectAllBook() {
       return bookDao.selectAllBook();
    }

    @Override
    public Book addBook(Book book) {
        bookDao.addBook(book);
        return book;
    }

    @Override
    public Book selectByPrimaryKey(Integer bookId) {
        return bookDao.selectByPrimaryKey(bookId);
    }

    @Override
    public Book selectbooksprice(String bookname) {
        return bookDao.selectbooksprice(bookname);
    }

    @Override
    public Book updateBook(Book book) {
        bookDao.updateBook(book);
        return book;
    }

    @Override
    public int deleteBook(Integer bookId) {
        return bookDao.deleteBook(bookId);
    }

    @Override
    public Book updateByPrimaryKey(Book book) {
        bookDao.updateByPrimaryKey(book);
        return book;
    }


}
