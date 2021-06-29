package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Course;
import com.trkj.thirdproject.entity.Detailcourse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface CourseService {
    //查询所有
    List<Course> selectAllCourse();
    //新增课程
    Course insertCourse(Course course);
    //修改名称、课时量、费用、开设状态
    Course updateCourse(Course course);
    //根据id查询课程
    Course selectByPrimaryKey(@PathVariable("courseId") Integer courseId);
    //根据课类Name查询所有课程
    List<Course> selectByCourseTypeName(String  classtypeName);
    //    根据课程编号查询所有

    List<Course> selectByCourseTypeId(Integer classtypeId);


    //根据课程id修改开课状态
    Course updateCourseState(Course course);
    //-----------------------------------------------课程详情数据--------------------------------------------------------------
    List<Detailcourse> selectByKey(Integer course_id);

    //新增课程详细
    Detailcourse batchDetails(Detailcourse detailcourse);

    Detailcourse updateByName(Detailcourse detailcourse);
    //    根据课程id查询课程详细系列号为100的数据（第一条数据）
    Detailcourse selectByCourseKey100(Integer course_id);
    //统计课程详细条数
    int selectdetailscount(Integer courseId);

}
