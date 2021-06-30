package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassesDao;
import com.trkj.thirdproject.dao.DetailcourseDao;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesDao classesdao;
    @Resource
    private DetailcourseDao  detailcoursedao;
    @Override
    public List<Classes> findAllclass() {
        return  classesdao.findAllclass();
    }

    @Override
    public Classes insert(Classes classes) {
        String number = "C";
        DateFormat dateFormat = new SimpleDateFormat("yyMMddss");
        String result = number+ dateFormat.format(new Date())+classes.toString().length();
        classes.setClassesNumber(result);
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
    public List<Classes> selectcourseId(Integer courseId) {
        return classesdao.selectcourseId(courseId);
    }
    @Override
    public Classes updateClassesOpen1(Classes classes) {
        classes.setStarteddate(new Date());
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
    public Detailcourse selectDetailCourse(Integer ClassId) {
        return classesdao.selectDetailCourse(ClassId);
    }

    @Override
    public Classes selectById(Integer classesId) {
       Classes classes= classesdao.selectById(classesId);
       return  classes;
    }

    @Override
    public Classes updateDetails(Classes classes) {
        classesdao.updateDetails(classes);
        return  classes;
    }

    @Override
    public List<Detailcourse> selectnotDetails(Integer classesid, Integer serial) {
        return classesdao.selectnotDetails(classesid, serial);
    }

    @Override
    public List<Detailcourse> selectSerial(Integer classId, String serial) {
      return   classesdao.selectSerial(classId,serial);

    }

    @Override
    public Classes classbegin(Classes classes) {
        log.debug(classes.getClassesId()+"classId");
        //得到课程详细信息
        Detailcourse detailcourse=classesdao.selectDetailCourse(classes.getClassesId());
        //当前课程详细的序列号
        int  a=Integer.parseInt(detailcourse.getSerial());
        log.debug(a+"ssssssssssssss");
        log.debug(a+"classaaaaaaaa");
        Classes classes1=classesdao.selectById(classes.getClassesId());
//        String serials=classes1.getDetailcourse().getSerial();
        log.debug(classes1.getCourseId()+"课程Id");
        List<Detailcourse> detailcourse1=detailcoursedao.selectByCourseKey(classes1.getCourseId());
        for (Detailcourse d:detailcourse1){
            classes.setSeriallist(Collections.singletonList(Integer.parseInt(d.getSerial())));
            log.debug(classes.getSeriallist()+"ddddddd");
        }
        for (int b:classes.getSeriallist()){
            if(a<b){
                Detailcourse detailcourse2=classesdao.selectDetailsByserial(classes.getClassesId(),String.valueOf(a));
                classes.setUpdatetime(new Date());
                classes.setDetailcourseId(detailcourse2.getDetailcourseId());
                classes.setWhendetails(classes1.getWhendetails()+1);
                classesdao.classbegin(classes);
                log.debug("成功修改一条");
                break;
            }else{
                break;
            }
        }
        return classes;
    }

    @Override
    public Detailcourse selectDetailsByserial(Integer classId, String serial) {
      return   classesdao.selectDetailsByserial(classId, serial);

    }


}
