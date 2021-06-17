package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Emp;
import com.trkj.thirdproject.entity.System;

import java.util.List;

public interface SystemService {
    List<System> findAllSystem();

    System insert(System record);

    List<Emp> selectEmp();

    int AddSystemSelect(int systemId,int empid);

    int delSystem(System system);

    System UpdateSystem(System system);

    int UpdatePublishSuspend(System system);

    List<System>findConditional(String index ,Object value);
}
