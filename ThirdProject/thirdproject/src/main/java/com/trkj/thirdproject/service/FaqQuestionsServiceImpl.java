package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.FaqQuestionsDao;
import com.trkj.thirdproject.entity.FaqQuestions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FaqQuestionsServiceImpl implements FaqQuestionsService {
    @Autowired
    private FaqQuestionsDao faqQuestionsDao;
    @Override

    public List<FaqQuestions> selectAIIFaqQuestions() {
        log.debug("开始查询所有FAQ");
        return faqQuestionsDao.selectAIIFaqQuestions();
    }

    @Override
    public FaqQuestions addFaqQuestions(FaqQuestions faqQuestions) {
         log.debug("开始查询");
         faqQuestionsDao.insert(faqQuestions);
         return faqQuestions;
    }

    @Override
    public FaqQuestions updateFaqQuestions(FaqQuestions faqQuestions) {
        return null;
    }

    @Override
    public void delFaqQuestions(int faqId) {

    }
}
