package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Source;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SourceDao {
    int deleteByPrimaryKey(Integer sourceId);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(Integer sourceId);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
//<!--  查询所有值-->
    List<Source> selectAIISources();
}