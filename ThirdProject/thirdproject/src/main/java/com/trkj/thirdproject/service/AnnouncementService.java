package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Announcement;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AnnouncementService {
    List<Announcement> findAllAnn();
    Announcement AddAnn(Announcement announcement);
    Announcement UpdateAnn(Announcement announcement);
    int delAnn(Announcement announcemen);
    Announcement AnnState(Announcement announcement);
    int AddAnnSelect(int aid,int empId);
    List<Announcement> findVaried(String name);
    List<Announcement> selectAnns(String name);

}
