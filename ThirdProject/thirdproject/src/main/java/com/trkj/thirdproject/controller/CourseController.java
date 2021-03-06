package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Classroom;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Course;
import com.trkj.thirdproject.entity.Detailcourse;
import com.trkj.thirdproject.service.ClassRoomService;
import com.trkj.thirdproject.service.CourseService;
import com.trkj.thirdproject.vo.CourseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @LogginAnnotation(message = "新增课程")
    public Course addCourse( @RequestBody Course course){
        log.debug("新增课程");
        course=courseservice.insertCourse(course);
        return course;
    }
    @PutMapping("/updateCourse")
    @LogginAnnotation(message = "修改课程")
    public Course updateCourse(@RequestBody Course course){
        log.debug("修改课程");
       course= courseservice.updateCourse(course);
        return course;
    }
    //根据id查询课程
    @GetMapping("/selectByCourseId")
    public Course selectByCourseId( @RequestParam Integer courseId){
        log.debug("根据id查询课程");
        return courseservice.selectByPrimaryKey(courseId);
    }
    //    根据课类名称查询课程
    @GetMapping("/selectByCourseTypeName")
    public List<Course> selectByCourseTypeName(@PathVariable("courseTypeName") String courseTypeName){
        log.debug("根据课类名称查询课程");
        return courseservice.selectByCourseTypeName(courseTypeName);
    }

    @PutMapping("/updateCourseState")
    @LogginAnnotation(message = "修改课程为开设状态")
    public Course updateCourseState(@RequestBody Course course){
        log.debug("修改课程状态");
        course.setUpdatetime(new Date());
        course =courseservice.updateCourseState(course);
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
    @GetMapping("/findAllClassRoom")
    public List<Classroom> findAllClassRoom(){
        return classRoomService.findAllRoom();
    }
    @PostMapping("/addClassRoom")
    @LogginAnnotation(message = "新增教室")
    public Classroom addClassRoom( @RequestBody Classroom classroom){
        log.debug("新增");
        classRoomService.insert(classroom);
        return classroom;
    }
    @PutMapping("/updateClassRoom")
    @LogginAnnotation(message = "修改教室")
    public Classroom updateClassRoom( @RequestBody Classroom classroom){
        log.debug("修改课程");
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
    @GetMapping("/selectByCourseKey100")
    public Detailcourse selectByCourseKey100( @PathVariable("courseid") Integer course_id){
        return courseservice.selectByCourseKey100(course_id);
    }
    @PostMapping("/addDetails")
    @LogginAnnotation(message = "新增课程详细")
    public Detailcourse addDetails( @RequestBody Detailcourse detailcourse){
        detailcourse= courseservice.batchDetails(detailcourse);
        return detailcourse;
    }

    @PutMapping("/updateByName")
    @LogginAnnotation(message = "修改课程详细")
    public Detailcourse updateByName( @RequestBody Detailcourse detailcourse){
        detailcourse=courseservice.updateByName(detailcourse);
        return detailcourse;
    }

    //统计课程详细条数
    @GetMapping("/selectdetailscount")
    public void selectdetailscount(@RequestParam("courseId") Integer courseId){
        courseservice.selectdetailscount(courseId);
    }
}
