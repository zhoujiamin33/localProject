package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Course;
import com.trkj.thirdproject.entity.Detailcourse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface CourseService {
    //查询所有
    List<Course> selectAllCourse();
    Course insertCoursetype(Course course);
    //修改名称、课时量、费用、开设状态
    Course updateCourse(Course course);
    //根据id查询课程
    Course selectByPrimaryKey(@PathVariable("courseId") Integer courseId);

    //-----------------------------------------------课程详情数据--------------------------------------------------------------
    List<Detailcourse> selectByKey(Integer course_id);
    Detailcourse addDetails(Detailcourse detailcourse);

    Detailcourse updateByName(Detailcourse detailcourse);
}
