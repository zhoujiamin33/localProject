package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Bookdelivery;
import com.trkj.thirdproject.entity.Warehouseincome;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookdeliveryService {
    int deleteByPrimaryKey(int bookdeliveryId);

    Bookdelivery insert(Bookdelivery bookdelivery);
    //------------------------------------------------------教材出库收入（财务部）------------------------------------------------
    //新增教材出库收入
    Warehouseincome insertincome(Warehouseincome warehouseincome);
    //撤销审核
    Warehouseincome updateReApproval(Warehouseincome warehouseincome);
    //审核
    Warehouseincome updateApproval(Warehouseincome warehouseincome);
    //查询所有出库收入
    List<Warehouseincome> selectAllincome();
    //多条件查询
    List<Warehouseincome> selectBycontionBook2(String startTime,String endTime);
}
