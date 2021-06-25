package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Studentoutstanding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface StudentoutstandingDao {
    int deleteByPrimaryKey(Integer outstandingId);
//新增报班缴费
    int insert(Studentoutstanding record);

    int insertSelective(Studentoutstanding record);
    //查询所有欠费补缴数据
    List<Studentoutstanding> selectoutstanding();

    int updateByPrimaryKeySelective(Studentoutstanding record);

    int updateByPrimaryKey(Studentoutstanding record);

    //查询报班缴费中缴费方式为预交学费的数据
    List<Studentoutstanding> selectoutonentry();

//    欠费补缴多条件查询
    List<Studentoutstanding> selectBycontion(String select,String input);
    //补缴管理多条件查询
    List<Studentoutstanding> selectByContionout(@Param("Approval") String Approval, @Param("value1") String  value1, @Param("value2") String value2);
//    审核欠费补缴
    int updateApprovalState(Studentoutstanding studentoutstanding);
    //    撤销审核欠费补缴
    int updateReApprovalState(Studentoutstanding studentoutstanding);
//    删除欠费补缴
    int deleteoutstanding(Studentoutstanding studentoutstanding);
    //修改补缴管理的累计欠费
    int updateAccumulated(Studentoutstanding studentoutstanding);
}
