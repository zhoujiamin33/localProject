package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.AnnouncementDao;
import com.trkj.thirdproject.dao.AnnouncementselectDao;
import com.trkj.thirdproject.entity.Announcement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementDao dao;
    @Autowired
    private AnnouncementselectDao ann;
    @Override
    public List<Announcement> findAllAnn() {
        return dao.findAllAnn();
    }

    @Override
    public Announcement AddAnn(Announcement announcement) {
        announcement.setAddtime(new Date());
        dao.insert(announcement);
        announcement.setAnnouncementState(0);
        return announcement;
    }

    @Override
    public Announcement UpdateAnn(Announcement announcement) {
        announcement.setUpdatetime(new Date());
        dao.updateByPrimaryKeySelective(announcement);
        return announcement;
    }

    @Override
    public int delAnn(Announcement announcemen) {
        dao.delAnn(announcemen);
        return 1;
    }

    @Override
    public Announcement AnnState(Announcement announcement) {
        dao.AnnState(announcement);
        return announcement;
    }

    @Override
    public int AddAnnSelect(int aid, int empId) {

        return ann.insert(aid,empId);
    }

    @Override
    public List<Announcement> findVaried(String name) {
        return dao.findVaried(name);
    }

    @Override
    public List<Announcement> selectAnns(String name) {
        return dao.selectAnns(name);
    }

    @Override
    public List<Announcement> findIdAnn(int id) {
        return dao.findIdAnn(id);
    }
}
