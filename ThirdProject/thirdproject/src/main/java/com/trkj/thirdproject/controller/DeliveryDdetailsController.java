package com.trkj.thirdproject.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Deliveryddetails;
import com.trkj.thirdproject.service.DeliveryDdetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DeliveryDdetailsController {
    @Autowired
    private DeliveryDdetailsService deliveryDdetailsService;

    @GetMapping("/findPage4")
    public PageInfo<Deliveryddetails> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Deliveryddetails> entityPage=deliveryDdetailsService.selectAll();
        PageInfo<Deliveryddetails> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PostMapping("/addDeliveryddetails")
    @LogginAnnotation(message = "新增教材出库详情")
    public Deliveryddetails insert(@RequestBody Deliveryddetails deliveryddetails){
        deliveryDdetailsService.insert(deliveryddetails);
        return deliveryddetails;
    }

    @GetMapping("/selectBookdelivery")
    public PageInfo<Deliveryddetails> selectByContion(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<Deliveryddetails> entityPage=deliveryDdetailsService.selectBookdelivery(value, input);
        PageInfo<Deliveryddetails> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

//    @PostMapping("/addDeliveryddetails")
//    public int insert(@RequestBody List<Deliveryddetails> deliveryddetails){
//        for( Deliveryddetails d:deliveryddetails){
//            deliveryDdetailsService.insert(d);
//        }
//
//        return 1;
//    }

//    @PostMapping("/addDeliveryddetails/{bid}/{bids}")
//    public int insert(@PathVariable("bid") int bid,@PathVariable("bids") List<Deliveryddetails> deliveryddetails){
//        log.debug("deliveryddetails啥子东西");
//        log.debug(deliveryddetails.toString());
//        for( Deliveryddetails d:deliveryddetails){
//
//            d.setBookdeliveryId(bid);
//            log.debug(d.toString());
//            deliveryDdetailsService.insert(d);
//
//        }
//
//
//        return 1;
//    }

    @DeleteMapping("/deldeliveryDdetails")
    @LogginAnnotation(message = "删除教材出库详情")
    public String deldeliveryDdetails(@RequestParam Integer deliveryddetailsId){
        log.debug("开始删除");
        deliveryDdetailsService.deleteByPrimaryKey(deliveryddetailsId);
        return "delOk";
    }
}
