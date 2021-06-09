package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface CourseDao {
    //查询所有
    List<Course> selectAllCourse();
    //修改名称、课时量、费用、开设状态
    int updateCourse(Course course);

    int deleteByPrimaryKey(Integer courseId);

    int insert(Course course);

    int insertCoursetype(Course course);

    int updateByPrimaryKey(Course course);

    Course selectByPrimaryKey(@PathVariable("courseId") Integer courseId);
}