package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Bookback;
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

    @DeleteMapping("/delBookback/{bookbackId}")
    public String delBookback(@PathVariable("bookbackId") int bookbackId){
        log.debug("开始删除");
        bookbackService.deleteByPrimaryKey(bookbackId);
        return "delOk";
    }
}
