package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.FaqQuestions;

import java.util.List;

public interface FaqQuestionsService {
    List<FaqQuestions> selectAIIFaqQuestions();
    FaqQuestions addFaqQuestions(FaqQuestions faqQuestions);
    FaqQuestions updateFaqQuestions(FaqQuestions faqQuestions);
    void delFaqQuestions(int faqId);
}
