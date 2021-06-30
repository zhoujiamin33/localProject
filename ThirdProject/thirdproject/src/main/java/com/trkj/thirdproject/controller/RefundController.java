package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Dropout;
import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.entity.Refund;
import com.trkj.thirdproject.service.DropoutService;
import com.trkj.thirdproject.service.RefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RefundController {
    @Autowired
    private RefundService refundservice;
    @Autowired
    private DropoutService dropoutService;
    @PostMapping("/insertRefund")
    @LogginAnnotation(message = "新增退费")
    public Refund  insertRefund(@RequestBody Refund refund){
        refund=refundservice.insertRefund(refund);
        return refund;
    }
    @GetMapping("/selectAllRefund")
    public PageInfo<Refund> selectAllRefund( @RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<Refund> entityPage = refundservice.selectAllRefund();
        PageInfo<Refund> refundPageInfo = new PageInfo<>(entityPage);
        return refundPageInfo;

    }
    @PutMapping("/updateapprovalrefund")
    @LogginAnnotation(message = "审核退费")
    public Refund updateapproval(@RequestBody Refund refund){
        refundservice.updateapproval(refund);
        return  refund;
    }
    @PutMapping("/updateRevokeapprovalrefund")
    @LogginAnnotation(message = "撤销审核退费")
    public Refund updateRevokeapproval(@RequestBody Refund refund){
        refundservice.updateRevokeapproval(refund);
        return  refund;
    }
    @PutMapping("/deleterefund")
    @LogginAnnotation(message = "删除退费")
    public Refund deleterefund( @RequestBody Refund refund){
        refundservice.deleterefund(refund);
        return  refund;
    }
    //多条件查询
    @GetMapping("/selectByContionRefund")
    public PageInfo<Refund> selectByContion(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,
        @RequestParam("Approval") int Approval,@RequestParam("value1") String value1, @RequestParam("value2") String value2,@RequestParam("input") String input){
        PageHelper.startPage(currentPage, pagesize);
        List<Refund> entityPage = refundservice.selectByContion(Approval, value1, value2, input);
        PageInfo<Refund> entryfeesPageInfo = new PageInfo<>(entityPage);
        return entryfeesPageInfo;
    }
}
