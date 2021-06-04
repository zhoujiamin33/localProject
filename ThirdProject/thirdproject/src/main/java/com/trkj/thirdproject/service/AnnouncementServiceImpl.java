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
        dao.updateByPrimaryKeySelective(announcement);
        return announcement;
    }

    @Override
    public int delAnn(List<Integer> multipleSelection, String ne, Date tm) {
        for (int AnnId : multipleSelection){
            log.debug(AnnId+"删除值的ID"+tm);
            dao.delAnn(AnnId,ne,tm);
        }
        return 1;
    }
}
