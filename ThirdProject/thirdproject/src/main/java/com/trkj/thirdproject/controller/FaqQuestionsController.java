package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.FaqQuestions;
import com.trkj.thirdproject.service.FaqQuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FaqQuestionsController {
    @Autowired
    private FaqQuestionsService faqQuestionsService;
    //查询
    @GetMapping("/findFaqQuestions")
    public List<FaqQuestions>findAIIFaqQuestions(){
        log.debug("Controller 方法调用");
        return faqQuestionsService.selectAIIFaqQuestions();
    }
    //新增
    @PostMapping("/FaqQuestions")
    public FaqQuestions addFaqQuestions(@RequestBody FaqQuestions faqQuestions){
        log.debug(faqQuestions.getAddname()+"--------");
        faqQuestions=faqQuestionsService.addFaqQuestions(faqQuestions);
        return faqQuestions;

    }
    //分页
    @GetMapping("/findPageFaq")
    public PageInfo<FaqQuestions> findPageFaq(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<FaqQuestions> entityPage=faqQuestionsService.selectAIIFaqQuestions();
        PageInfo<FaqQuestions> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

}
