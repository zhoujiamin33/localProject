package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BackDao;
import com.trkj.thirdproject.dao.StudentstatusDao;
import com.trkj.thirdproject.dao.SuspendeDao;
import com.trkj.thirdproject.entity.Back;
import com.trkj.thirdproject.entity.Suspende;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BackServiceImpl implements BackService {
    @Autowired
    private BackDao backDao;
    @Autowired
    private SuspendeDao suspendeDao;
    @Autowired
    private StudentstatusDao studentstatusDao;
    @Override
    public Back insertSelective(Back record) {
        backDao.insertSelective(record);//新增复课
        Suspende suspende=new Suspende();
        suspende.setSuspendeId(record.getSuspendeId());
//        suspendeDao.updateByPrimaryKeySelective(suspende);//根据停课查询以前停课的已上课时
        return record;
    }

    @Override
    public Back updateByPrimaryKeySelective(Back record) {
        backDao.updateByPrimaryKeySelective(record);
        return record;
    }
}
