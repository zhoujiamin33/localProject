package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Suspende;

import java.util.List;

public interface SuspendeService {
    //    新增停课
    Suspende insertSelective(Suspende record);
    //<!--  查询所有（班级、学员、课程）-->
    List<Suspende> selectAll();
//    修改状态或者是删除修改时效性
Suspende updateByPrimaryKeySelective(Suspende record);
//根据编号查询
Suspende selectByPrimaryKey(Integer suspendeId);

}
