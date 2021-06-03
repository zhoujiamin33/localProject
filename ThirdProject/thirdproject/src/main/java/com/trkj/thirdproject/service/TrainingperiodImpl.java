package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.TrainingperiodDao;
import com.trkj.thirdproject.entity.Trainingperiod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrainingperiodImpl implements TrainingperiodService {
    @Autowired
    private TrainingperiodDao trainingperiodDao;
    @Override
    public List<Trainingperiod> selectAllTrainingperiods() {
        log.debug("开始查询所有部门信息");
        return trainingperiodDao.selectAllTrainingperiods();
    }

    @Override
    public Trainingperiod addTrainingperiod(Trainingperiod trainingperiod) {
        log.debug("开始新增");
        trainingperiodDao.addTrainingperiod(trainingperiod);
        return trainingperiod;
    }

    @Override
    public Trainingperiod updateTrainingperiod(Trainingperiod trainingperiod) {
        trainingperiodDao.updateByPrimaryKey(trainingperiod);
        return trainingperiod;
    }

    @Override
    public int delTrainingperiod(int periodId) {
        trainingperiodDao.deleteByPrimaryKey(periodId);
        return periodId;
    }

}
