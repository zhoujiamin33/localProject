package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface AnnouncementDao {
    int deleteByPrimaryKey(Integer announcementId);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    Announcement selectByPrimaryKey(Integer announcementId);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);

    List<Announcement> findAllAnn();

    int delAnn(@Param("updatename") int announcementId, @Param("updatetime") String updatename, @Param("announcementId") Date updatetime);
}