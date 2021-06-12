package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Studentstatus;
import com.trkj.thirdproject.service.StudentService;
import com.trkj.thirdproject.service.StudentstatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentstatusController {
    @Autowired
    private StudentstatusService studentstatusService;
    @Autowired
    private StudentService studentService;

//    后台查询咨询登记，新增学员交接，查询学员交接，修改学员交接中审核状态，新增学生档案
//    根据学员编号查询
    @GetMapping("/findstuclass/{studentId}")
    public List<Studentstatus> findstuclass(@PathVariable("studentId") Integer studentId){
        return studentstatusService.selectstu_class( studentId);
    }
//    新增学员状态表
    @PostMapping("/addstudentstatus")
    public Studentstatus addstudentstatus(@RequestBody Studentstatus studentstatus){
         studentstatus=studentstatusService.AddStudentstatus(studentstatus);
     log.debug(studentstatus.toString());
        return studentstatus;
    }

}
