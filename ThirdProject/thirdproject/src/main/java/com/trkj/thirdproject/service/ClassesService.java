package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesService {
    //查询所有外键表：course
    List<Classes> findAllclass();
    //新增班级
    Classes insert(Classes classes);
    //修改班级
    Classes updateByPrimaryKeySelective(Classes record);
    //班级表中的多条件查询
    List<Classes> selectByContion(@Param("value")String value, @Param("input") String input);
}
