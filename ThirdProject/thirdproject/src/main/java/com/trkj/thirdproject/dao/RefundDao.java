package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Refund;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import java.util.List;

@Mapper
public interface RefundDao {
    int deleteByPrimaryKey(Integer refundId);
    //新增退费
    Refund insertRefund(Refund refund);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
    //查询退费
    List<Refund> selectAllRefund();
}