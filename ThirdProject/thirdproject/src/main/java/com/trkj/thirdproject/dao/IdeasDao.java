package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Ideas;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IdeasDao {
    int deleteByPrimaryKey(Integer ideasId);

    int insert(Ideas record);

    int insertSelective(Ideas record);

    Ideas selectByPrimaryKey(Integer ideasId);

    int updateByPrimaryKeySelective(Ideas record);

    int updateByPrimaryKey(Ideas record);

    int updateneirong(Ideas record);

    List<Ideas> selectAllfc();

    List<Ideas> selectAllsd();

//    List<Ideas> selectAllqb();
//
//    List<Ideas> selectAlldhf();
//
//    List<Ideas> selectAllyhf();
}