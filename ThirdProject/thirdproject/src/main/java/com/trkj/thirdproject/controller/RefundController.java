package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Refund;
import com.trkj.thirdproject.service.RefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RefundController {
    @Autowired
    private RefundService refundservice;
    @PostMapping("/insertRefund")
    public Refund  insertRefund( Refund refund){
        return refundservice.insertRefund(refund);
    }
    @GetMapping("/selectAllRefund")
    public List<Refund> selectAllRefund(){
        return refundservice.selectAllRefund();
    }
}
