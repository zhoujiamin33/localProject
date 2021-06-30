package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Storageexpenditure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StorageexpenditureDao {
    int deleteByPrimaryKey(Integer expensesId);
    //新增教材入库
    int insert(Storageexpenditure storageexpenditure);

    int insertSelective(Storageexpenditure record);

    Storageexpenditure selectByPrimaryKey(Integer expensesId);

    int updateByPrimaryKeySelective(Storageexpenditure record);

    int updateByPrimaryKey(Storageexpenditure record);
    //查询所有教材入库
    List<Storageexpenditure> selectAllStorage();
    //撤销审核
    int updateReApproval(Storageexpenditure storageexpenditure);
    //审核
    int updateApproval(Storageexpenditure storageexpenditure);
    //删除
    int deleteTimeliness(Storageexpenditure storageexpenditure);
    //多条件查询
    List<Storageexpenditure> selectBycontionBook(@Param("startTime")String startTime,@Param("endTime")String endTime);
}