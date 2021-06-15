package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.entity.Studentoutstanding;

import java.util.List;

public interface OutStandingService {
    //查询报班缴费中缴费方式为预交学费的数据
    List<Studentoutstanding> selectoutonentry();
    //新增报班缴费
    Studentoutstanding insert(Studentoutstanding studentoutstanding);
    //    多条件查询
    List<Studentoutstanding> selectBycontion(String select,String input);
    //查询所有欠费补缴数据
    List<Studentoutstanding> selectoutstanding();
    //    审核欠费补缴
    Studentoutstanding updateApprovalState(Studentoutstanding studentoutstanding);
    //    撤销审核欠费补缴
    Studentoutstanding updateReApprovalState(Studentoutstanding studentoutstanding);
    //    删除欠费补缴
    Studentoutstanding deleteoutstanding(Studentoutstanding studentoutstanding);

}
