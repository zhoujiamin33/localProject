package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SemesterDao;
import com.trkj.thirdproject.entity.Semester;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SemesterServiceImpl implements SemesterService {
    @Autowired
    private SemesterDao semesterDao;
    @Override
    public List<Semester> selectAIISemesters() {
        log.debug("开始查询所有学期");
        return semesterDao.selectAIISemesters();
    }

    @Override
    public Semester addSemester(Semester semester) {
        log.debug("开始插入信息");
        semesterDao.insert(semester);
        return semester;
    }

    @Override
    public Semester updateSemester(Semester semester) {
         log.debug("修改成功");
         semesterDao.updateByPrimaryKey(semester);
         return semester;
    }

    @Override
    public void delSemester(int Semester_Id) {

    }
}
