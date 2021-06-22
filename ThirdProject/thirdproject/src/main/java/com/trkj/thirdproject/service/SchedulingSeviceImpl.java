package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SchedulingDao;
import com.trkj.thirdproject.entity.Scheduling;
import com.trkj.thirdproject.entity.Trainingperiod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SchedulingSeviceImpl implements SchedulingSevice {
    @Resource
    private SchedulingDao schedulingdao;

    @Override
    public Scheduling insert(Scheduling scheduling) {
         for(int ps:scheduling.getPeriods()){
             scheduling.setAddtime(new Date());
             scheduling.setPeriodId(ps);
             schedulingdao.insert(scheduling);
         }
         return scheduling;
    }

    @Override
    public List<Scheduling> selectAllScheduling() {
        return schedulingdao.selectAllScheduling();
    }

    @Override
    public Scheduling selectremove(int periodId,String classroomName,String empName) {
        return  schedulingdao.selectremove(periodId, classroomName, empName);
    }
}
