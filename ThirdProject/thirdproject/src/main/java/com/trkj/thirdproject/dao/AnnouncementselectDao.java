package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Announcementselect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AnnouncementselectDao {
    int deleteByPrimaryKey(Integer announcementselectId);

    int insert(@Param("announcementId")int announcementId,@Param("empId")int empId);

    int insertSelective(Announcementselect record);

    Announcementselect selectByPrimaryKey(Integer announcementselectId);

    int updateByPrimaryKeySelective(Announcementselect record);

    int updateByPrimaryKey(Announcementselect record);
}