package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Register;

import java.util.Date;
import java.util.List;

public interface RegisterService {
    //咨询登记查询显示
    List<Register> selectRegister();
    //新增
    Register insert(Register register);
    //修改
    Register updateRegister(Register register);

    //删除
    int delstuRegTime(List<Integer>RegisterId, String nu, Date tm);
}
