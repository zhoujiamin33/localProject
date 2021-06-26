package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface RegisterDao {
    int deleteByPrimaryKey(Integer registerId);

    int insertRegister(Register record);

    int insertSelective(Register record);

    //学员表中查看详情获取课程顾问：根据咨询编号查询
    Register selectRegister(Integer RegisterId);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
    //   咨询登记交的状态为已就读接给学员表中
    List<Register> showstudent();
    //根据id查询咨询登记
    Register selectByregisterId(Integer registerId);

    //删除
    int delstuRegTime(@Param("registerId" ) int Register_Id, @Param( "lastupdatename") String LastUpdateName, @Param("lastupdatetime")Date LastUpdateTime);

    //查询咨询登记表中咨询状态为有意向的数据
    List<Register> selectAttentState();

    //修改咨询登记的缴费状态
    int updatepaystate(Integer registerId );
    //<!--查询出咨询登记为已缴费已就读学员的信息-->
    List<Register> selectPay_AttentState();

    //报表统计中统计每种咨询方式的使用次数
    List<Register> ConsultationmodeStatistics();

}

