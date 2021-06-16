package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Register;
import org.springframework.web.bind.annotation.PathVariable;

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

    //查询咨询登记表中咨询状态为有意向的数据
    List<Register> selectAttentState();

    //根据id查询咨询登记
    Register selectByregisterId(@PathVariable("registerId") Integer registerId);
    //修改咨询登记的缴费状态
    int updatepaystate(Integer registerId );
}
