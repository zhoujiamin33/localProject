package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Supplementary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplementaryDao {
    int deleteByPrimaryKey(Integer supplementaryId);

    int insert(Supplementary record);

    int insertsupplementary(Supplementary record);

    Supplementary selectByPrimaryKey(Integer supplementaryId);

    int updateByPrimaryKeySelective(Supplementary record);

    int updateByPrimaryKey(Supplementary record);
}