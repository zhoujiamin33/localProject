package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Bookdelivery;
import com.trkj.thirdproject.entity.Storageexpenditure;
import com.trkj.thirdproject.entity.Warehouseincome;
import com.trkj.thirdproject.service.BookdeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookdeliveryController {
    @Autowired
    private BookdeliveryService bookdeliveryService;

//    @DeleteMapping("/deldelBookDelivery/{bookdeliveryId}")
//    public String deldelBookDelivery(@PathVariable("bookdeliveryId") int bookdeliveryId){
//        log.debug("开始删除");
//        bookdeliveryService.deleteByPrimaryKey(bookdeliveryId);
//        return "delOk";
//    }

    @PostMapping("/addBookdelivery")
    @LogginAnnotation(message = "新增教材出库总表")
    public Bookdelivery insert(@RequestBody Bookdelivery bookdelivery){
        bookdeliveryService.insert(bookdelivery);
        log.debug(bookdelivery.getBookdeliveryId()+":::bookdeliveryId");
        return bookdelivery;
    }
    //-------------------------------------------新增教材出库收入----------------------------------------------------------
    @PostMapping("/insertincome")
    @LogginAnnotation(message = "新增教材出库收入")
    public Warehouseincome insert(@RequestBody Warehouseincome warehouseincome){
        return bookdeliveryService.insertincome(warehouseincome);
    }
    @PutMapping("/updateReApprovalincome")
    @LogginAnnotation(message = "撤销审核教材出库收入")
    public Warehouseincome updateReApproval(@RequestBody Warehouseincome warehouseincome){
        bookdeliveryService.updateReApproval(warehouseincome);
        return  warehouseincome;
    }
    @PutMapping("/updateApprovalincome")
    @LogginAnnotation(message = "审核教材出库收入")
    public Warehouseincome updateApproval(@RequestBody Warehouseincome warehouseincome){
        bookdeliveryService.updateApproval(warehouseincome);
        return  warehouseincome;
    }
    @GetMapping("/selectAllincome")
    public PageInfo<Warehouseincome> selectAllincome(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Warehouseincome> entityPage=bookdeliveryService.selectAllincome();
        PageInfo<Warehouseincome> incomePageinfo=new PageInfo<>(entityPage);
        return incomePageinfo;
    }
    @GetMapping("/selectBycontionBook2")
    public PageInfo<Warehouseincome> selectBycontionBook2(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime){
        PageHelper.startPage(currentPage,pagesize);
        List<Warehouseincome> entityPage=bookdeliveryService.selectBycontionBook2(startTime, endTime);
        PageInfo<Warehouseincome> entityPageInfo=new PageInfo<>(entityPage);
        return entityPageInfo;
    }
}
