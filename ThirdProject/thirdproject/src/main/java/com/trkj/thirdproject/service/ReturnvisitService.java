package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Returnvisit;

import java.util.List;

public interface ReturnvisitService {
    //回访查询显示
    List<Returnvisit> selectReturnvisit(Integer registerId);
    //回访新增
    Returnvisit inserRreturnvisit(Returnvisit returnvisit);
    //回访批量删除
    int delstuRetTime(List<Integer>Returnvisit_Id);

}
