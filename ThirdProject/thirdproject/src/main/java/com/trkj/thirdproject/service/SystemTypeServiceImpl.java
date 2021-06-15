package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SystemtypeDao;
import com.trkj.thirdproject.entity.Systemtype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SystemTypeServiceImpl implements SystemTypeService {
    @Autowired
    private SystemtypeDao dao;
    @Override
    public List<Systemtype> findAllSysType() {
        return dao.findAllSysType();
    }
}
