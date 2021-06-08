package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.AnnouncementDao;
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
    @Override
    public List<Announcement> findAllAnn() {
        return dao.findAllAnn();
    }

    @Override
    public Announcement AddAnn(Announcement announcement) {
        announcement.setAddtime(new Date());
        dao.insertSelective(announcement);
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
}
