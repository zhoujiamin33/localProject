package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Scheduling;
import com.trkj.thirdproject.service.SchedulingSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SchedulingController {
    @Autowired
    private SchedulingSevice schedulingSevice;
    @PostMapping("/insertSheduling")
    @LogginAnnotation(message = "新增排课")
    public Scheduling insert(@RequestBody Scheduling scheduling){
        scheduling= schedulingSevice.insert(scheduling);
        log.debug(scheduling.getCoursecount()+"eee");
        return scheduling;
    }
    @GetMapping("/selectAllScheduling")
    public List<Scheduling> selectAllScheduling(){
        return schedulingSevice.selectAllScheduling();
    }
    @GetMapping("/selectremove/{periodId}/{classroomName}/{empName}")
    public Scheduling selectremove(@PathVariable("periodId") int periodId,@PathVariable("classroomName")  String classroomName,@PathVariable("empName") String empName){
        return schedulingSevice.selectremove(periodId, classroomName, empName);
    }
}
