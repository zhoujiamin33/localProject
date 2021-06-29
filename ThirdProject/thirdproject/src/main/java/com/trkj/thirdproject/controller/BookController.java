package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class BookController {
    @Resource
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        bookService.addBook(book);
        return book;
    }

    @GetMapping("/selectAllBook")
    private List<Book> selectAllBook(){
        log.debug("Controller方法调用");
        return bookService.selectAllBook();
    }

    @GetMapping("/selectbooksprice")
    private Book selectAllBook(@RequestParam Integer bookId){
        log.debug("Controller方法调用");
        return bookService.selectByPrimaryKey(bookId);
    }

    @GetMapping("/findPage3")
    public PageInfo<Book> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Book> entityPage=bookService.selectAllBook();
        PageInfo<Book> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        log.debug("开始修改");
        bookService.updateBook(book);
        return book;
    }
}
