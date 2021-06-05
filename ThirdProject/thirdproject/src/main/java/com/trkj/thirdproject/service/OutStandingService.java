package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Studentoutstanding;

import java.util.List;

public interface OutStandingService {
    //查询报班缴费中缴费方式为预交学费的数据
    List<Studentoutstanding> selectoutonentry();
}
