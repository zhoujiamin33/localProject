package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Interview;

public interface InterviewDao {
    int deleteByPrimaryKey(Integer detailsId);

    int insert(Interview record);

    int insertSelective(Interview record);

    Interview selectByPrimaryKey(Integer detailsId);

    int updateByPrimaryKeySelective(Interview record);

    int updateByPrimaryKey(Interview record);
}