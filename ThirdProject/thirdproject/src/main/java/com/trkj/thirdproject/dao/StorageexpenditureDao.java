package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Storageexpenditure;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageexpenditureDao {
    int deleteByPrimaryKey(Integer expensesId);
    //新增教材入库
    int insert(Storageexpenditure storageexpenditure);

    int insertSelective(Storageexpenditure record);

    Storageexpenditure selectByPrimaryKey(Integer expensesId);

    int updateByPrimaryKeySelective(Storageexpenditure record);

    int updateByPrimaryKey(Storageexpenditure record);
}