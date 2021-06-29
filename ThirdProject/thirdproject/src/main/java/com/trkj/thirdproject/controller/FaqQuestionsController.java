package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.FaqQuestions;
import com.trkj.thirdproject.entity.Source;
import com.trkj.thirdproject.service.FaqQuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @PostMapping("/AddFaqQuestions")
    public FaqQuestions addFaqQuestions(@RequestBody FaqQuestions faqQuestions){
        String addname="TSM管理员";
        log.debug(faqQuestions.getAddname()+"--------");
        faqQuestions=faqQuestionsService.addFaqQuestions(faqQuestions);
        return faqQuestions;
    }

    //批量删除
    @PutMapping("/DelFaq/{faqId}")
    public int delstuFaqTime(@PathVariable("faqId") List<Integer>faqId){
        log.debug("启用FAQ批量删除");

        String deletename="阿狸";
        Date deletetime=new Date();
        return faqQuestionsService.delstuFaqTime(faqId,deletename,deletetime);
    }

    //修改
    @PutMapping("/UpFaqQuestions")
    public FaqQuestions updateFaqQuestions(@RequestBody FaqQuestions faqQuestions){
        log.debug("FAQ开始修改");
        faqQuestions=faqQuestionsService.updateFaqQuestions(faqQuestions);
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

//    FAQ模糊查询
    @GetMapping("/selectFaqFuzzyquery")
    public PageInfo<FaqQuestions> selectFaqFuzzyquery(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<FaqQuestions> entityPage=faqQuestionsService.selectFaqFuzzyquery(value, input);
        PageInfo<FaqQuestions> faqQuestionsPageInfo=new PageInfo<>(entityPage);
        return faqQuestionsPageInfo;
}
}
