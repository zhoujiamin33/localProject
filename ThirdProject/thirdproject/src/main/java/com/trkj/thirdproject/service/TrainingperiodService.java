package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Trainingperiod;

import java.util.List;

public interface TrainingperiodService {
    List<Trainingperiod> selectAllTrainingperiods();

    Trainingperiod addTrainingperiod(Trainingperiod trainingperiod);

    Trainingperiod updateTrainingperiod(Trainingperiod trainingperiod);

    int delTrainingperiod(int periodId);

}
