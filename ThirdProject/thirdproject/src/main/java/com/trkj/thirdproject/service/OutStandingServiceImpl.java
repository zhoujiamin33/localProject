package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.StudentoutstandingDao;
import com.trkj.thirdproject.entity.Studentoutstanding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//新增欠费补缴
    @Override
    public Studentoutstanding insert(Studentoutstanding studentoutstanding) {
        String number = "BJ";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String result = number+ dateFormat.format(new Date()) + studentoutstanding.toString().length();
        studentoutstanding.setOutstandingName(result);
        studentoutstanding.setOutstandingDate(new Date());
         outstandingdao.insert(studentoutstanding);
         return studentoutstanding;
    }

    @Override
    public List<Studentoutstanding> selectBycontion(String select, String input) {
        return outstandingdao.selectBycontion(select, input);
    }

    @Override
    public List<Studentoutstanding> selectoutstanding() {
        return outstandingdao.selectoutstanding();
    }

    @Override
    public Studentoutstanding updateApprovalState(Studentoutstanding studentoutstanding) {
        studentoutstanding.setApprovaltime(new Date());
        outstandingdao.updateApprovalState(studentoutstanding);

        return studentoutstanding;
    }

    @Override
    public Studentoutstanding updateReApprovalState(Studentoutstanding studentoutstanding) {
        studentoutstanding.setRevokeapptime(new Date());
        outstandingdao.updateReApprovalState(studentoutstanding);
        return studentoutstanding;
    }

    @Override
    public Studentoutstanding deleteoutstanding(Studentoutstanding studentoutstanding) {
        studentoutstanding.setDeletetime(new Date());
        outstandingdao.deleteoutstanding(studentoutstanding);
        return studentoutstanding;
    }



}
