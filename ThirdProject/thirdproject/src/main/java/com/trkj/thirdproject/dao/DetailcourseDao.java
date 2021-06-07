package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Detailcourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailcourseDao {
    int deleteByPrimaryKey(Integer detailcourseId);

    int insert(Detailcourse record);

    int insertSelective(Detailcourse record);

//    根据课程id查询课程详细数据
    List<Detailcourse> selectByCourseKey(Integer course_id);

    int updateByPrimaryKeySelective(Detailcourse record);

    int updateByPrimaryKey(Detailcourse record);
    int addDetails(Detailcourse detailcourse);

    int updateByName(Detailcourse detailcourse);
}