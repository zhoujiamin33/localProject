package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Mapper
public interface RegisterDao {
    int deleteByPrimaryKey(Integer registerId);

    int insertRegister(Register record);

    int insertSelective(Register record);

    List<Register> selectRegister();

    int updateByPrimaryKeySelective(Register record);
    
    int updateByPrimaryKey(Register record);
    //   咨询登记交的状态为已就读接给学员表中
    List<Register> showstudent();
    //根据id查询咨询登记
    Register selectByregisterId(@PathVariable("registerId") Integer registerId);

    //删除
    int delstuRegTime(@Param("registerId" ) int Register_Id, @Param( "lastupdatename") String LastUpdateName, @Param("lastupdatetime")Date LastUpdateTime);

    //查询咨询登记表中咨询状态为有意向的数据
    List<Register> selectAttentState();

    //修改咨询登记的缴费状态
    Register updatepaystate(Integer registerId );

}

