package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.OpjournalDao;
import com.trkj.thirdproject.entity.Opjournal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OpjournalServiceImpl implements OpjournalService {
    @Autowired
    private OpjournalDao opjournalDao;
    @Override
    public Opjournal addopjournal(Opjournal opjournal) {
        opjournalDao.insertSelective(opjournal);
        return opjournal;
    }

    @Override
    public Opjournal updateopjournal(Opjournal opjournal) {
        opjournalDao.updateByPrimaryKeySelective(opjournal);
        return opjournal;
    }

    @Override
    public int deleteopjournal(Integer opjournalId) {
        return opjournalDao.deleteByPrimaryKey(opjournalId);
    }

    @Override
    public List<Opjournal> selectByPrimary() {
        List<Opjournal> opjournalList=opjournalDao.selectByPrimary();
        return opjournalList;
    }
}
