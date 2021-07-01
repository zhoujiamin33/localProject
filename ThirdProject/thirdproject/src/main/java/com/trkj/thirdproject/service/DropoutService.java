package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Dropout;

import java.util.List;

public interface DropoutService {
//    新增退学
    Dropout insertSelective(Dropout record);
    //    查询所有
    List<Dropout> selectAlldropout();
//    模糊查询
List<Dropout> findclaNmae_stuNameAndxuehao(String index,String value);
//点击审核状态为已审核或者删除按钮时效性为1
Dropout updateByPrimaryKeySelective(Dropout record);
//根据退学编号查询
Dropout selectByPrimaryKey(Integer dropId);


}
