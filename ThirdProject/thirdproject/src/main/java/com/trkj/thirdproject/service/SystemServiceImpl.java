package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EmpDao;
import com.trkj.thirdproject.dao.SystemDao;
import com.trkj.thirdproject.dao.SystemselectDao;
import com.trkj.thirdproject.entity.Emp;
import com.trkj.thirdproject.entity.System;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SystemServiceImpl implements SystemService {
    @Autowired
    private SystemDao dao;
    @Autowired
    private EmpDao empDao;
    @Autowired
    private SystemselectDao systemselectDao;
    @Override
    public List<System> findAllSystem() {
        return dao.findAllSystem();
    }

    @Override
    public System insert(System record) {
        dao.insert(record);
        return record;
    }

    @Override
    public List<Emp> selectEmp() {
        return empDao.selectEmp();
    }

    @Override
    public int AddSystemSelect(int systemId,int empid) {
        return systemselectDao.insert(systemId,empid);
    }

    @Override
    public int delSystem(System system) {
        system.setDeletetime(new Date( ));
        return dao.updateByPrimaryKey(system);
    }

    @Override
    public System UpdateSystem(System system) {
        dao.updateByPrimaryKeySelective(system);
        return system;
    }

    @Override
    public int UpdatePublishSuspend(System system) {
        return dao.UpdatePublishSuspend(system);
    }

    @Override
    public List<System> findConditional(String index, Object value) {
        return dao.findConditional(index,value);
    }

    @Override
    public List<System> findSystem(String index, Object value) {
        return dao.findSystem(index,value);
    }

}
