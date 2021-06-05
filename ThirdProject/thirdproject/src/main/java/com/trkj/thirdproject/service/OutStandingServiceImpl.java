package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.StudentoutstandingDao;
import com.trkj.thirdproject.entity.Studentoutstanding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class OutStandingServiceImpl implements OutStandingService {
    @Resource
    private StudentoutstandingDao outstandingdao;
    @Override
    public List<Studentoutstanding> selectoutonentry() {
        return outstandingdao.selectoutonentry();
    }
}
