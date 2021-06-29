package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Bookback;
import com.trkj.thirdproject.entity.Bookdelivery;
import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Ideas;
import com.trkj.thirdproject.service.BookbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookbackController {
    @Autowired
    private BookbackService bookbackService;


    @GetMapping("/findPage6")
    public PageInfo<Bookback> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookback> entityPage=bookbackService.selectAll();
        PageInfo<Bookback> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @DeleteMapping("/delBookback")
    @LogginAnnotation(message = "删除退回订单")
    public String delBookback(@RequestParam int bookbackId){
        log.debug("开始删除");
        bookbackService.deleteByPrimaryKey(bookbackId);
        return "delOk";
    }

//    @PutMapping("/updateBookback")
//    @LogginAnnotation(message = "批量删除员工")
//    public Bookback updateByPrimaryKey(@RequestBody Bookback bookback){
//        log.debug("开始修改");
//        bookbackService.updateByPrimaryKey(bookback);
//        return bookback;
//    }

    @PostMapping("/addBookback")
    @LogginAnnotation(message = "新增退回订单")
    public Bookback insert(@RequestBody Bookback bookback){
        bookbackService.insert(bookback);
        return bookback;
    }


    @GetMapping("/selectBookback")
    public PageInfo<Bookback> selectBookback(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookback> entityPage=bookbackService.selectBookBack(value, input);
        PageInfo<Bookback> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
