package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.entity.Register;

import java.math.BigDecimal;
import java.util.List;

public interface EntryfeesService {
    List<Entryfees> selectKey();
    Entryfees insertentryfees(Entryfees entryfees);
    //修改审核
    Entryfees updateapproval(Entryfees entryfees);
    //撤销审核
    Entryfees updateRevokeapproval(Entryfees entryfees);
    //删除
    Entryfees deleteByPrimaryKey(Entryfees entryfees);
    //根据id查询
    Entryfees selectByfeeid(Integer feeId);
    //     补缴之后，修改累计欠费的值
    int  updateFeesAccumulated(Integer outstandingId, BigDecimal feesaccumulated);
}
