package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Entryfees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface EntryfeesDao {
    int deleteByPrimaryKey(Entryfees entryfees);

    int insertentryfees(Entryfees entryfees);

    int insertSelective(Entryfees record);

    List<Entryfees> selectKey();
    //多条件查询
    List<Entryfees> selectBycontion(@Param("ApprovalState") int ApprovalState,@Param("value2") String value2,
     @Param("input") String input);

    int updateByPrimaryKey(Entryfees record);

    int updateapproval(Entryfees entryfees);

    int updateRevokeapproval(Entryfees entryfees);
    //根据id查询
    Entryfees selectByfeeid(Integer feeId);
    //     补缴之后，修改累计欠费的值
    int  updateFeesAccumulated(Entryfees entryfees);


}