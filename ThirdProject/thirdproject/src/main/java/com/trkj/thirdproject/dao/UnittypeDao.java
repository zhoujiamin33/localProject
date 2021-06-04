package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Unittype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnittypeDao {
    int deleteByPrimaryKey(Integer unittypeId);

    int insert(Unittype record);

    int insertSelective(Unittype record);

    Unittype selectByPrimaryKey(Integer unittypeId);

    int updateByPrimaryKeySelective(Unittype record);

    int updateByPrimaryKey(Unittype record);

    List<Unittype> selectAllUnitType();

    int updateTimeLiness(Unittype unittype);
}