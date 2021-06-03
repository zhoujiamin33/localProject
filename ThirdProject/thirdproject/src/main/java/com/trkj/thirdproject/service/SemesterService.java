package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Semester;

import java.util.List;

public interface SemesterService {
    List<Semester> selectAIISemesters();
    Semester addSemester(Semester semester);
    Semester updateSemester(Semester semester);
    void delSemester(int SemesterId);
}
