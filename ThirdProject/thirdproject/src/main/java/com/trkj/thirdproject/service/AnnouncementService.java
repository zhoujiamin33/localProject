package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Announcement;

import java.util.Date;
import java.util.List;

public interface AnnouncementService {
    List<Announcement> findAllAnn();
    Announcement AddAnn(Announcement announcement);
    Announcement UpdateAnn(Announcement announcement);
    int delAnn(List<Integer> multipleSelection, String ne, Date tm);
}
