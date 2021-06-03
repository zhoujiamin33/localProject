package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Session;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SessionDao {
    int deleteByPrimaryKey(Integer sessionId);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Integer sessionId);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);

    List<Session> selectAIISessions();
}