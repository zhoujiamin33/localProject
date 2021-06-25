package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BackDao;
import com.trkj.thirdproject.entity.Back;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackServiceImpl implements BackService {
    @Autowired
    private BackDao backDao;
    @Override
    public Back insertSelective(Back record) {
        backDao.insertSelective(record);
        return record;
    }
}
