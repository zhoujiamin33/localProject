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
    public Course insertCoursetype(Course course) {
        course.setAddname("Tsm管理员");
        coursedao.insertCoursetype(course);
        log.debug("111111"+course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        course.setUpdatename("Tsm管理员");
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


    //----------------------------------------------------课程详情数据----------------------------------------------------------------
    @Override
    public List<Detailcourse> selectByKey(Integer course_id) {
        log.debug("查询课程详细");
        return detailcoursedao.selectByCourseKey(course_id);
    }
    @Override
    public Detailcourse addDetails(Detailcourse detailcourse) {
        detailcourse.setAddname("Tsm管理员");
        detailcourse.setAddtime(new Date());
        log.debug("课程详细名："+detailcourse.getDetailcourseName());
        detailcoursedao.addDetails(detailcourse);

        return detailcourse;
    }

    @Override
    public Detailcourse updateByName(Detailcourse detailcourse) {
        log.debug("修改课程详细");
        detailcoursedao.updateByName(detailcourse);
        return detailcourse;
    }
}
