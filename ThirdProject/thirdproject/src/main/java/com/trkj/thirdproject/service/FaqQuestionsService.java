package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.FaqQuestions;
import com.trkj.thirdproject.entity.Source;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FaqQuestionsService {
    //显示所有--查询
    List<FaqQuestions> selectAIIFaqQuestions();
    //Faq新增
    FaqQuestions addFaqQuestions(FaqQuestions faqQuestions);
    //Faq修改
    FaqQuestions updateFaqQuestions(FaqQuestions faqQuestions);
    //批量删除
    int delstuFaqTime(List<Integer>FaqId, String dna, Date dtm);
    //    FAQ模糊查询
    List<FaqQuestions> selectFaqFuzzyquery(@Param("value")String value, @Param("input") String input);

}
