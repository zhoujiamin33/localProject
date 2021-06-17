package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.FaqQuestionsDao;
import com.trkj.thirdproject.entity.FaqQuestions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class FaqQuestionsServiceImpl implements FaqQuestionsService {
    @Resource
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

    //修改
    @Override
    public FaqQuestions updateFaqQuestions(FaqQuestions faqQuestions) {
         faqQuestionsDao.updateByPrimaryKey(faqQuestions);
         return faqQuestions;
    }
    //FAQ批量删除修改时效性
    @Override
    public int delstuFaqTime(List<Integer>FaqId, String deletename, Date deletetime) {
        for (int unitid :FaqId){
            faqQuestionsDao.delstuFaqTime(unitid,deletename,deletetime);
        }
        return 1;
    }
}
