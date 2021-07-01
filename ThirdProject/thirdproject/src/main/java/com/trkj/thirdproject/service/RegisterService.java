package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.entity.Source;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RegisterService {
    //咨询登记查询显示
    List<Register> selectRegister();

    //新增
    Register insert(Register register);
    //修改
    Register updateRegister(Register register);

    //删除
    int delstuRegTime(List<Integer>RegisterId);

    //查询咨询登记表中咨询状态为有意向的数据
    List<Register> selectAttentState();

    //根据id查询咨询登记
    Register selectByregisterId(Integer registerId);
    //修改咨询登记的缴费状态
    int updatepaystate(Integer registerId );

    //报表统计中统计每种咨询方式的使用次数
    List<Register> ConsultationmodeStatistics();

    //咨询登记分页
    List<Register> selectAIIRegister();


    //咨询登记模糊查询
    List<Register> selectRegisterlivery(@Param("value")String value, @Param("input") String input);

}
