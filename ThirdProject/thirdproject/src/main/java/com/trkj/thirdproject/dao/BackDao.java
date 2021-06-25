package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Back;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BackDao {
    int deleteByPrimaryKey(Integer backId);

    int insert(Back record);

    int insertSelective(Back record);

    Back selectByPrimaryKey(Integer backId);

    int updateByPrimaryKeySelective(Back record);

    int updateByPrimaryKey(Back record);
}