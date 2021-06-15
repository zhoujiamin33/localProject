package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SystemselectDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SystemSelectServiceImpl implements SystemSelectService {
    @Autowired
    private SystemselectDao systemselectDao;

}
