package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassroomDao;
import com.trkj.thirdproject.dao.CourseDao;
import com.trkj.thirdproject.dao.DetailcourseDao;
import com.trkj.thirdproject.entity.Course;
import com.trkj.thirdproject.entity.Detailcourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao coursedao;
    @Resource
    private ClassroomDao classdao;
    @Resource
    private DetailcourseDao detailcoursedao;
    @Override
    public List<Course> selectAllCourse() {
       return coursedao.selectAllCourse();
    }

    @Override
    public Course insertCourse(Course course) {
        course.setAddtime(new Date());
        coursedao.insertCourse(course);
        log.debug("111111"+course);
        return course;
    }


    @Override
    public Course updateCourse(Course course) {
        course.setUpdatetime(new Date());
        log.debug("课程修改成功！");
        coursedao.updateCourse(course);
        return course;
    }

    @Override
    public Course selectByPrimaryKey(@PathVariable("courseId") Integer courseId) {
        Course course= coursedao.selectByPrimaryKey(courseId);
        return course;
    }

    @Override
    public List<Course> selectByCourseTypeName(String  classtypeName) {
        return coursedao.selectByCourseTypeName(classtypeName);
    }

    @Override
    public List<Course> selectByCourseTypeId(Integer classtypeId) {
        return coursedao.selectByCourseTypeId(classtypeId);
    }

    @Override
    public Course updateCourseState(Course course) {
        coursedao.updateCourseState(course);
        return course;
    }


    //----------------------------------------------------课程详情数据----------------------------------------------------------------
    @Override
    public List<Detailcourse> selectByKey(Integer course_id) {
        log.debug("查询课程详细");
        return detailcoursedao.selectByCourseKey(course_id);
    }




    @Override
    public Detailcourse updateByName(Detailcourse detailcourse) {
        log.debug("修改课程详细");
        detailcourse.setUpdatetime(new Date());
        detailcoursedao.updateByName(detailcourse);
        return detailcourse;
    }

    @Override
    public Detailcourse selectByCourseKey100(Integer course_id) {
        return detailcoursedao.selectByCourseKey100(course_id);
    }

    @Override
    public int selectdetailscount(Integer courseId) {
        log.debug(courseId+"课程Id");
        return detailcoursedao.selectdetailscount(courseId);
    }

    //批量新增课程详细
    @Override
    public Detailcourse batchDetails(Detailcourse detailcourse) {
        Course course=coursedao.selectByPrimaryKey(detailcourse.getCourseId());
        Integer details=detailcoursedao.selectdetailscount(detailcourse.getCourseId());
        log.debug(details+"bbbbbbbbbbb");
        int shengyu=course.getClasshours()-details;
        log.debug(shengyu+"shengyu");
        for (int i=1;i<=shengyu;i++){
            detailcourse.setAddtime(new Date());
            String coursename=course.getCourseName();
            detailcourse.setDetailcourseName(coursename+"第"+i+"课时");
            log.debug("课程详细名："+detailcourse.getDetailcourseName());
            detailcoursedao.batchDetails(detailcourse);
        }
        return detailcourse;
    }
}
