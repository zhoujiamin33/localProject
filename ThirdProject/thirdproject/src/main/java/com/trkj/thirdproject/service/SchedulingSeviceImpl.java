package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SchedulingDao;
import com.trkj.thirdproject.entity.Scheduling;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SchedulingSeviceImpl implements SchedulingSevice {
    @Resource
    private SchedulingDao schedulingdao;

    @Override
    public Scheduling insert(Scheduling scheduling) {
         schedulingdao.insert(scheduling);
         return scheduling;
    }
}
