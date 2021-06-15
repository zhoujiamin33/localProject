package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Bookdelivery;

public interface BookdeliveryService {
    int deleteByPrimaryKey(int bookdeliveryId);

    Bookdelivery insert(Bookdelivery bookdelivery);
}
