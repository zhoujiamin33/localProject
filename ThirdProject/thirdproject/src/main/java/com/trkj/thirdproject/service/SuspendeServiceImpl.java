package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SuspendeDao;
import com.trkj.thirdproject.entity.Suspende;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SuspendeServiceImpl implements SuspendeService {
    @Autowired
    private SuspendeDao suspendeDao;
    @Override
    public Suspende insertSelective(Suspende record) {
        suspendeDao.insertSelective(record);
        return record;
    }

    @Override
    public List<Suspende> selectAll() {
        return suspendeDao.selectAll();
    }

    @Override
    public Suspende updateByPrimaryKeySelective(Suspende record) {
        suspendeDao.updateByPrimaryKeySelective(record);
        return record;
    }

    @Override
    public Suspende selectByPrimaryKey(Integer suspendeId) {
        return suspendeDao.selectByPrimaryKey(suspendeId);
    }
}
