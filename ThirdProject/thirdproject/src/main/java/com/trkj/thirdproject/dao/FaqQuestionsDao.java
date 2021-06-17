package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.FaqQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface FaqQuestionsDao {
    int deleteByPrimaryKey(Integer faqId);

    //新增
    int insert(FaqQuestions record);

    //删除--修改时效性
    int delstuFaqTime(@Param("faqId" ) int FAQ_Id, @Param( "deletename") String DeleteName, @Param("deletetime") Date DeleteTime);

    int insertSelective(FaqQuestions record);

    FaqQuestions selectByPrimaryKey(Integer faqId);

    int updateByPrimaryKeySelective(FaqQuestions record);

    int updateByPrimaryKey(FaqQuestions record);

    List<FaqQuestions> selectAIIFaqQuestions();
}