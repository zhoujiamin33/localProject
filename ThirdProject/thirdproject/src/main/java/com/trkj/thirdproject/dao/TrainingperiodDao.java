package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Trainingperiod;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrainingperiodDao {
    int deleteByPrimaryKey(Integer periodId);

    int insert(Trainingperiod record);

    int insertSelective(Trainingperiod record);

    Trainingperiod selectByPrimaryKey(Integer periodId);

    int updateByPrimaryKeySelective(Trainingperiod record);

    int updateByPrimaryKey(Trainingperiod record);

    List<Trainingperiod> selectAllTrainingperiods();

    int addTrainingperiod(Trainingperiod record);
}