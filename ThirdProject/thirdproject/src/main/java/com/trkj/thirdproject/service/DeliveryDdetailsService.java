package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Deliveryddetails;

import java.util.List;

public interface DeliveryDdetailsService {
    List<Deliveryddetails> selectAll();

    Deliveryddetails insert(Deliveryddetails deliveryddetails);

    int deleteByPrimaryKey(int deliveryddetails);
}
