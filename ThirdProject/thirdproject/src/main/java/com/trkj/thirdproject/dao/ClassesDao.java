package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Classes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassesDao {
    int deleteByPrimaryKey(Integer classesId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classesId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}