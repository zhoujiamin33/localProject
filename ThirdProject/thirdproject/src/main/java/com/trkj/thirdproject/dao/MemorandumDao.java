package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Memorandum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemorandumDao {
    int deleteByPrimaryKey(Integer memorandumId);

    int insert(Memorandum record);

    int insertSelective(Memorandum record);

    Memorandum selectByPrimaryKey(Integer memorandumId);

    int updateByPrimaryKeySelective(Memorandum record);

    int updateByPrimaryKey(Memorandum record);

    List<Memorandum> selectAllMemorandum();
}