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
    //新增课程详细
    int batchDetails(Detailcourse detailcourse);
    //修改课程详细
    int updateByName(Detailcourse detailcourse);
    //    根据课程id查询课程详细系列号为100的数据（第一条数据）
    Detailcourse selectByCourseKey100(Integer course_id);
    //统计课程详细条数
    int selectdetailscount(Integer courseId);


}