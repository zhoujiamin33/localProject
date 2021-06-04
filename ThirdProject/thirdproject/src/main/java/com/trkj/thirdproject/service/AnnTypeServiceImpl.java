package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.AnnouncementtypeDao;
import com.trkj.thirdproject.entity.Announcementtype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AnnTypeServiceImpl implements AnnTypeService {
    @Autowired
    private AnnouncementtypeDao dao;
    @Override
    public List<Announcementtype> selectAllType() {
        return dao.selectAllAnnType();
    }

    @Override
    public int AnnTypeAdd(Announcementtype announcementtype) {
        announcementtype.setAddtime(new Date());
        return dao.insertSelective(announcementtype);
    }

    @Override
    public int AnnTypeUpdate(Announcementtype announcementtype) {
        announcementtype.setUpdatetime(new Date());
        return dao.updateByPrimaryKeySelective(announcementtype);
    }

    @Override
    public int AnnTypeDelete(int annTypeId) {
        return dao.deleteByPrimaryKey(annTypeId);
    }

    @Override
    public int updateTimeLiness(Announcementtype announcementtype) {
        announcementtype.setDeletetime(new Date());
        return dao.updateTimeLiness(announcementtype);
    }

    @Override
    public List<Announcementtype> selectDelAnnType() {
        return dao.selectDelAnnType();
    }
}
