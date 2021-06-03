package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Semester;

import com.trkj.thirdproject.service.SemesterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @GetMapping("/findSemesters")
    public List<Semester>findAIISemesters(){
        log.debug("Controller 方法调用");
        return semesterService.selectAIISemesters();
    }
    @PostMapping("/Semester")
    public Semester addSemester(@RequestBody Semester semester){
        log.debug(semester.getAddname()+"-----------------");
        semester=semesterService.addSemester(semester);
        return semester;
    }
    @PutMapping("/Semester")
    public Semester updateSemester(@RequestBody Semester semester){
        log.debug("开始修改");
        log.debug(semester.toString());
        semester=semesterService.updateSemester(semester);
        return semester;
    }
    //分页
    @GetMapping("/findPageSemester")
    public PageInfo<Semester> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Semester> entityPage=semesterService.selectAIISemesters();
        PageInfo<Semester> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}







