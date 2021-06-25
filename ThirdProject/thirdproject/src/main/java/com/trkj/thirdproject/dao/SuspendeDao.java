package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Supplementary;
import com.trkj.thirdproject.entity.Suspende;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SuspendeDao {
    int deleteByPrimaryKey(Integer suspendeId);

    int insert(Suspende record);

    int insertSelective(Suspende record);

    Suspende selectByPrimaryKey(Integer suspendeId);

    int updateByPrimaryKeySelective(Suspende record);

    int updateByPrimaryKey(Suspende record);
//
//<!--  查询所有（班级、学员、课程）-->
    List<Suspende> selectAll();
    // 模糊查询
    List<Suspende> findName_number(@Param("index") String index, @Param("value") String value);
}