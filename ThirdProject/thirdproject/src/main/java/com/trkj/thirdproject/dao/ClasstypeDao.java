package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Classtype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

@Mapper
public interface ClasstypeDao {
    //查询所有
    List<Classtype> selectAllClassType();

//    模糊查询
    List<Classtype> selectByname(String ClasstypeName);


//    新增
    int insert(Classtype classtype);


////根据id查询数据
//    Classtype selectByPrimaryKey(Integer classtypeId);


    //修改
    int updateByPrimaryKey(Classtype classtype);
    //删除,修改状态
    int updateCourseType(@Param("classtypeId") int classtypeId, @Param("deletename") String deletename, @Param("deletetime") Date deleteTime);


}
