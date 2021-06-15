package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.service.BookstorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookstorageController {
    @Autowired
    private BookstorageService bookstorageService;

    @PostMapping("/addBookstorage")
    public Bookstorage addBookstorage(@RequestBody Bookstorage bookstorage){
        bookstorageService.addBookstorage(bookstorage);
        return bookstorage;
    }

    @GetMapping("/findPage1")
    public PageInfo<Bookstorage> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookstorage> entityPage=bookstorageService.selectAll();
        PageInfo<Bookstorage> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PutMapping("/updateBookstorage")
    public Bookstorage updateByPrimaryKey(@RequestBody Bookstorage bookstorage){
        log.debug("开始修改");
        bookstorageService.updateByPrimaryKey(bookstorage);
        return bookstorage;
    }

    @DeleteMapping("/delBookstorage/{mbookstorageId}")
    public String delBookstorage(@PathVariable("mbookstorageId") int mbookstorageId){
        log.debug("开始删除");
        bookstorageService.deleteByPrimaryKey(mbookstorageId);
        return "delOk";
    }
}
