package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.entity.Returnvisit;

import java.util.List;

public interface ReturnvisitService {
    //回访查询显示
    List<Returnvisit> selectReturnvisit(Integer registerId);
    //回访新增
    Returnvisit inserRreturnvisit(Returnvisit returnvisit);
    //回访批量删除
    int delstuRetTime(List<Integer>Returnvisit_Id);

    //报表统计中统计每种咨询方式的使用次数
    List<Returnvisit> Numberofreturnvisits();
}
