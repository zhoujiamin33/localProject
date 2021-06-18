package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Deliveryddetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryDdetailsService {
    List<Deliveryddetails> selectAll();

    Deliveryddetails insert(Deliveryddetails deliveryddetails);

    int deleteByPrimaryKey(int deliveryddetails);

    List<Deliveryddetails> selectBookdelivery(@Param("value")String value, @Param("input") String input);
}
