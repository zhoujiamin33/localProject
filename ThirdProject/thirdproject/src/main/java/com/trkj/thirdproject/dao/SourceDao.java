package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Source;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SourceDao {
    int deleteByPrimaryKey(Integer sourceId);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(Integer sourceId);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
//<!--  分页-->
    List<Source> selectAIISources();
//    模糊查询
    List<Source> selectSourceFuzzyquery(@Param("value")String value, @Param("input") String input);

}