package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Detailsupplementary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailsupplementaryDao {
    int deleteByPrimaryKey(Integer detailsupplementaryId);

    int insert(Detailsupplementary record);

    int insertSelective(Detailsupplementary record);

    Detailsupplementary selectByPrimaryKey(Integer detailsupplementaryId);

    int updateByPrimaryKeySelective(Detailsupplementary record);

    int updateByPrimaryKey(Detailsupplementary record);
}