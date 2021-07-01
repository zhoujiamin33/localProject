package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.*;
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
    @LogginAnnotation(message = "新增教材入库")
    public Bookstorage addBookstorage(@RequestBody Bookstorage bookstorage){
        bookstorageService.addBookstorage(bookstorage);
        return bookstorage;
    }

    @GetMapping("/findPage1")
    public PageInfo<Bookstorage> findPage1(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookstorage> entityPage=bookstorageService.selectAll();
        PageInfo<Bookstorage> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PutMapping("/updateBookstorage")
    @LogginAnnotation(message = "修改教材入库")
    public Bookstorage updateByPrimaryKey(@RequestBody Bookstorage bookstorage){
        log.debug("开始修改");
        bookstorageService.updateByPrimaryKey(bookstorage);
        return bookstorage;
    }

    @GetMapping("/selectBookstorage")
    public PageInfo<Bookstorage> selectByContion(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<Bookstorage> entityPage=bookstorageService.selectBookstorage(value, input);
        PageInfo<Bookstorage> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PutMapping("/deleteByPrimaryKey")
    @LogginAnnotation(message = "删除教材入库")
    public Bookstorage deleteByPrimaryKey(@RequestBody Bookstorage bookstorage){
        log.debug("开始修改");
        bookstorageService.deleteByPrimaryKey(bookstorage);
        return bookstorage;
    }
    //=====================================教材入库支出=======================================================================
//    新增教材入库支出
    @PostMapping("/insertExpenditure")
    @LogginAnnotation(message = "新增教材入库支出")
    public Storageexpenditure insertExpenditure(@RequestBody Storageexpenditure storageexpenditure){
        bookstorageService.insertStorageexpenditure(storageexpenditure);
        return storageexpenditure;
    }
    //查询所有教材入库
    @GetMapping("/selectAllStorage")
    public PageInfo<Storageexpenditure> selectAllStorage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Storageexpenditure> entityPage=bookstorageService.selectAllStorage();
        PageInfo<Storageexpenditure> storagePageinfo=new PageInfo<>(entityPage);
        return storagePageinfo;
    }
    @PutMapping("/updateApproval")
    @LogginAnnotation(message = "审核教材入库支出")
    public Storageexpenditure updateApproval( @RequestBody Storageexpenditure storageexpenditure){
        storageexpenditure=bookstorageService.updateApproval(storageexpenditure);
        return  storageexpenditure;
    }
    @PutMapping("/updateReApproval")
    @LogginAnnotation(message = "撤销审核教材入库支出")
    public Storageexpenditure updateReApproval( @RequestBody Storageexpenditure storageexpenditure){
        storageexpenditure=bookstorageService.updateReApproval(storageexpenditure);
        return  storageexpenditure;
    }
    @PutMapping("/deleteTimeliness")
    @LogginAnnotation(message = "删除教材入库支出")
    public Storageexpenditure deleteTimeliness( @RequestBody Storageexpenditure storageexpenditure){
        storageexpenditure=bookstorageService.deleteTimeliness(storageexpenditure);
        return  storageexpenditure;
    }
    @GetMapping("/selectBycontionBook")
    public PageInfo<Storageexpenditure> selectBycontionBook(@RequestParam("currentPage") int currentPage,
                                                            @RequestParam("pagesize") int pagesize,
                                                            @RequestParam(value = "startTime",required = false) String startTime,
                                                            @RequestParam(value = "endTime",required =false) String endTime){

        PageHelper.startPage(currentPage,pagesize);
        List<Storageexpenditure> entityPage=bookstorageService.selectBycontionBook(startTime,endTime);
        PageInfo<Storageexpenditure> entityPageInfo=new PageInfo<>(entityPage);
        return entityPageInfo;
    }
}
