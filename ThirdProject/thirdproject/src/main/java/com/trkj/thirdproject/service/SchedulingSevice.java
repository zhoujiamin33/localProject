package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Scheduling;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchedulingSevice {
    //新增排课
    Scheduling insert(Scheduling scheduling);
    //查询所有排课
    List<Scheduling> selectAllScheduling();
    //查询这一时间段选择的教师、教室有没有被占用
    Scheduling selectremove(int periodId,String classroomName,String empName);
}
