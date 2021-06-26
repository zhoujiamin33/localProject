package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Refund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RefundService {
    //新增退费
    Refund insertRefund(Refund refund);
    //查询退费
    List<Refund> selectAllRefund();
    //审核退费
    Refund updateapproval(Refund refund);
    //撤销审核退费
    Refund updateRevokeapproval(Refund refund);
    //删除
    Refund deleterefund(Refund refund);
    //多条件查询
    List<Refund> selectByContion(int Approval,String value1, String value2, String input);
}
