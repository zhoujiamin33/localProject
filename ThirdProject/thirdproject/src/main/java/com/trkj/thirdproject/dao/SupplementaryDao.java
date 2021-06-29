package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Supplementary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SupplementaryDao {
    int deleteByPrimaryKey(Integer supplementaryId);

    int insert(Supplementary record);

    int insertSelective(Supplementary record);

    Supplementary selectByPrimaryKey(Integer supplementaryId);

    int updateByPrimaryKeySelective(Supplementary record);

    int updateByPrimaryKey(Supplementary record);

    //查看补报课程总表
    List<Supplementary> selectall();
// 模糊查询
    List<Supplementary> findName_number(@Param("index") String index,@Param("value") String value);
    //根据补报编号查询补报信息
    Supplementary selectBysuppId(Integer supplementary);


}