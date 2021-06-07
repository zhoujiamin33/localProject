package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
//    <!--  咨询登记交的状态为已就读接给学员表中-->
    List<Register> showstudent();

    //删除
    int delstuRegTime(@Param("registerId" ) int Register_Id, @Param( "lastupdatename") String LastUpdateName, @Param("lastupdatetime")Date LastUpdateTime);
}

