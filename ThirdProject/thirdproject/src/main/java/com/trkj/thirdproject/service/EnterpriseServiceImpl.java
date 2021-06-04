package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EnterpriseDao;
import com.trkj.thirdproject.entity.Enterprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public Enterprise seleallenterprise() {
        return enterpriseDao.seleallenterprise();
    }

    @Override
    public Enterprise updateEnterprise(Enterprise record) {
       enterpriseDao.updateByPrimaryKey(record);
        return record;
    }
}
