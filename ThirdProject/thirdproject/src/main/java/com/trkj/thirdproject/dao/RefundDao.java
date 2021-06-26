package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Refund;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedNotifications;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface RefundDao {
    int deleteByPrimaryKey(Integer refundId);
    //新增退费
    int insertRefund(Refund refund);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer refundId);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
    //查询退费
    List<Refund> selectAllRefund();
    //审核退费
    int updateapproval(Refund refund);
    //撤销审核退费
    int updateRevokeapproval(Refund refund);
    //删除
    int deleterefund(Refund refund);
    //多条件查询
    List<Refund> selectByContion(@Param("Approval")int Approval,@Param("value1")String value1,@Param("value2")String value2,@Param("input")String input);
}