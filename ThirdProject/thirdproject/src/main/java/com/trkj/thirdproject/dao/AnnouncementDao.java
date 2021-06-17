package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Announcement;
import com.trkj.thirdproject.entity.Emp;
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

    int delAnn(Announcement announcement);

    int AnnState(Announcement announcement);

    List<Announcement> findVaried(@Param("name")String name);

    List<Announcement> selectAnns(@Param("name")String name);

    List<Emp> selectEmp(@Param("AnnouncementId")int aid);
}