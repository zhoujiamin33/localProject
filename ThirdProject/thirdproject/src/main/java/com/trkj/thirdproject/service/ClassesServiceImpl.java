package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassesDao;
import com.trkj.thirdproject.entity.Classes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesDao classesdao;
    @Override
    public List<Classes> findAllclass() {
        return  classesdao.findAllclass();
    }

    @Override
    public Classes insert(Classes classes) {
        String number = "C";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String result = number+ dateFormat.format(new Date())+classes.toString().length();
        classes.setClassesNumber(result);
        classes.setAddname("admin");
        classes.setAddtime(new Date());
        classesdao.insert(classes);
        log.debug(result);
        return classes;
    }

    @Override
    public Classes updateByPrimaryKeySelective(Classes classes) {
        classesdao.updateByPrimaryKeySelective(classes);
        return classes;
    }
}
