package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Announcementtype;

import java.util.List;

public interface AnnTypeService {
    List<Announcementtype> selectAllType();
    int AnnTypeAdd(Announcementtype announcementtype);
    int AnnTypeUpdate(Announcementtype announcementtype);
    int AnnTypeDelete(int annTypeId);
    int updateTimeLiness(Announcementtype announcementtype);
    List<Announcementtype> selectDelAnnType();
}
