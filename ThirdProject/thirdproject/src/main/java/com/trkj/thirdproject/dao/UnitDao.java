package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UnitDao {
    int deleteByPrimaryKey(Integer unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

    List<Unit> fandAllUnit();

    int delUnit(@Param("unitId") int UnitId,@Param("deletename") String DeleteName,@Param("deletetime") Date DeleteTime);

    int findUnitType(int id);
}