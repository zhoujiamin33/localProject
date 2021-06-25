package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.StudentstatusDao;
import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.entity.Studentstatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentstatusServiceImpl implements StudentstatusService {
    @Autowired
    private StudentstatusDao studentstatusDao;
    @Override
    public List<Studentstatus> selectstu_class(Integer studentId) {
        return studentstatusDao.selectstu_class(studentId);
    }

    @Override
    public Studentstatus AddStudentstatus(Studentstatus studentstatus) {
        studentstatusDao.insertSelective(studentstatus);
        return studentstatus;
    }
//改变停课状态
    @Override
    public Studentstatus updatestustart(Studentstatus record) {
      studentstatusDao.updateByPrimaryKeySelective(record);
        return record;
    }
//查询状态表
    @Override
    public List<Studentstatus> selectByPrimaryKey(Integer studentId) {
        List<Studentstatus> studentstatus=studentstatusDao.selectByPrimaryKey(studentId);
        return studentstatus;
    }

    @Override
    public Studentstatus updateByPrimaryKeySelective(Studentstatus studentstatus) {
      studentstatusDao.updateByPrimaryKeySelective(studentstatus);
        return studentstatus;
    }

    @Override
    public Studentstatus selectByPrimaryKeyId(Integer studentstatusId) {
        Studentstatus studentstatus=studentstatusDao.selectByPrimaryKeyId(studentstatusId);
        return studentstatus;
    }


}
