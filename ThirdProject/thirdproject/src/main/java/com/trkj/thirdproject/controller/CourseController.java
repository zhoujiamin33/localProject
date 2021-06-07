package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.trkj.thirdproject.entity.Classroom;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Course;
import com.trkj.thirdproject.entity.Detailcourse;
import com.trkj.thirdproject.service.ClassRoomService;
import com.trkj.thirdproject.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseservice;
    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/findcourse")
    public PageInfo<Course> findcourse(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询所有课程及分页");
        PageHelper.startPage(currentPage,pagesize);
        List<Course> entityPage=courseservice.selectAllCourse();
        PageInfo<Course> CoursePageInfo=new PageInfo<>(entityPage);
        return CoursePageInfo;
    }

    @PostMapping("/addCourse")
    public Course addCourse( @RequestBody Course course){
        log.debug("新增课程");
        course=courseservice.insertCoursetype(course);
        return course;
    }
    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course){
        log.debug("修改课程");
        courseservice.updateCourse(course);
        return course;
    }
    @PutMapping("/updatecourseState")
    public Course updatecourseState(@RequestBody Course course){
        log.debug("停报");
        courseservice.updatecourseState(course);
        return course;
    }

    //----------------------------------------教室表--------------------------------------------------------------------

    @GetMapping("/findClassroom")
    public PageInfo<Classroom> findClassroom(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询所有教室");
        PageHelper.startPage(currentPage,pagesize);
        List<Classroom> entityPage=classRoomService.findAllRoom();
        PageInfo<Classroom> classroomPageInfo=new PageInfo<>(entityPage);
        return classroomPageInfo;
    }
    @PostMapping("/addClassRoom")
    public Classroom addClassRoom( @RequestBody Classroom classroom){
        log.debug("新增教室");
        classRoomService.insert(classroom);
        return classroom;
    }
    @PutMapping("/updateClassRoom")
    public Classroom updateClassRoom( @RequestBody Classroom classroom){
        log.debug("修改教室");
        classRoomService.updateByKey(classroom);
        return classroom;
    }

    //-------------------------------------------------课程详情表-----------------------------------------------------------------
    @GetMapping("/findDetailCourses")
    public PageInfo<Detailcourse> findDetailCourses(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("courseId") int courseId){
        log.debug("查询所有课程详细");
        PageHelper.startPage(currentPage,pagesize);
        List<Detailcourse> entityPage=courseservice.selectByKey(courseId);
        PageInfo<Detailcourse> detailcoursePageInfo=new PageInfo<>(entityPage);
        return detailcoursePageInfo;
    }
    @PostMapping("/addDetails")
    public Detailcourse addDetails( @RequestBody Detailcourse detailcourse){
        log.debug("新增课程详细");
        log.debug(detailcourse.getDetailcourseName()+detailcourse.getAddname()+detailcourse.getCourseId());
        courseservice.addDetails(detailcourse);
        return detailcourse;
    }
    @PutMapping("/updateDetails")
    public Detailcourse upadteDetails( @RequestBody Detailcourse detailcourse){
        log.debug("修改课程详细");
        log.debug(detailcourse.getDetailcourseName()+detailcourse.getAddname()+detailcourse.getCourseId());
        courseservice.updateByName(detailcourse);
        log.debug("修改成功");
        return detailcourse;
    }
}
