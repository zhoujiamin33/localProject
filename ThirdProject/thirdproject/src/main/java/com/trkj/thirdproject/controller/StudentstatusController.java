package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Studentstatus;
import com.trkj.thirdproject.service.ClassesService;
import com.trkj.thirdproject.service.StudentService;
import com.trkj.thirdproject.service.StudentstatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class StudentstatusController {
    @Resource
    @Autowired
    private StudentstatusService studentstatusService;
    @Autowired
    private ClassesService classesService;

//    后台查询咨询登记，新增学员交接，查询学员交接，修改学员交接中审核状态，新增学生档案
//    根据学员编号查询findstuclass
    @GetMapping("/findstuclass")
    public List<Studentstatus> findstuclass(@RequestParam Integer studentId){
        List<Studentstatus> studentstatuseslist=studentstatusService.selectstu_class(studentId);
        return studentstatuseslist;
    }
//    //   <!--根据课程编号查询所对应的班级-->
@GetMapping("/findcourseId")
public List<Classes> findcourseId(@RequestParam("courseId")Integer courseId){
    List<Classes> classesList=classesService.selectcourseId(courseId);
        return classesList;
}
//    新增学员状态表
    @PostMapping("/addstudentstatus")
    @LogginAnnotation(message = "新增学员记录")
    public Studentstatus addstudentstatus(@RequestBody Studentstatus studentstatus){
         studentstatus=studentstatusService.AddStudentstatus(studentstatus);
     log.debug(studentstatus.toString());
        return studentstatus;
    }
@GetMapping("/findstudentstatusId")
    public Studentstatus findstudentId(@RequestParam("studentstatusId") Integer studentstatusId){
        Studentstatus studentstatus=studentstatusService.selectByPrimaryKeyId(studentstatusId);
        log.debug("状态："+studentstatus.toString());
        return studentstatus;
}
}
