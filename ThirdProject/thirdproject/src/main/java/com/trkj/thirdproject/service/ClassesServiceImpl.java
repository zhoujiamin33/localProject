package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassesDao;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
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

    @Override
    public List<Classes> selectByContion(String value, String input) {
       return classesdao.selectByContion(value, input);
    }

    @Override
    public Classes selectcourseId(Integer courseId) {
        return classesdao.selectcourseId(courseId);
    }
    @Override
    public Classes updateClassesOpen1(Classes classes) {
        classes.setUpdatetime(new Date());
        classesdao.updateClassesOpen1(classes);
        return classes;
    }

    @Override
    public Classes updateClassesOpen0(Classes classes) {
        classes.setUpdatetime(new Date());
        classesdao.updateClassesOpen0(classes);
        return classes;
    }

    @Override
    public List<Classes> selectOpen() {
        return classesdao.selectOpen();
    }

    @Override
    public List<Detailcourse> selectDetailCourse() {
        return classesdao.selectDetailCourse();
    }

    @Override
    public Classes selectById(Integer classesId) {
       Classes classes= classesdao.selectById(classesId);
       return  classes;
    }
}
