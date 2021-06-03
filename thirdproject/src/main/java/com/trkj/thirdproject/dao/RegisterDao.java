package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Register;

public interface RegisterDao {
    int deleteByPrimaryKey(Integer registerId);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer registerId);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}