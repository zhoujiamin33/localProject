package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Refund;

import java.util.List;

public interface RefundService {
    //新增退费
    Refund insertRefund(Refund refund);
    //查询退费
    List<Refund> selectAllRefund();
}
