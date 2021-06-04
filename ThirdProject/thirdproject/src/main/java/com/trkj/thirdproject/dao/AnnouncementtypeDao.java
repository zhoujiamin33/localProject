package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Announcementtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementtypeDao {
    int deleteByPrimaryKey(Integer announcementtypeId);

    int insert(Announcementtype record);

    int insertSelective(Announcementtype record);

    Announcementtype selectByPrimaryKey(Integer announcementtypeId);

    int updateByPrimaryKeySelective(Announcementtype record);

    int updateByPrimaryKey(Announcementtype record);

    List<Announcementtype> selectAllAnnType();

    List<Announcementtype> selectDelAnnType();

    int updateTimeLiness(Announcementtype announcementtype);
}