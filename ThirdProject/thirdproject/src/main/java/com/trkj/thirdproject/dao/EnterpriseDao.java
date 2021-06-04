package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Enterprise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseDao {
    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(Enterprise record);

    Enterprise selectByPrimaryKey(Integer enterpriseId);
//修改
    int updateByPrimaryKey(Enterprise record);
    Enterprise seleallenterprise();
}