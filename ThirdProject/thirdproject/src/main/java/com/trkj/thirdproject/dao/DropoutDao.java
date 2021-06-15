package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Dropout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DropoutDao {
    int deleteByPrimaryKey(Integer dropId);

    int insert(Dropout record);

    int insertSelective(Dropout record);

    Dropout selectByPrimaryKey(Integer dropId);

    int updateByPrimaryKeySelective(Dropout record);

    int updateByPrimaryKey(Dropout record);
//    查询所有
    List<Dropout> selectAlldropout();
//    模糊查询
    List<Dropout> findclaNmae_stuNameAndxuehao(@Param("index") String index,@Param("value") String value);
}