package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Suggest;
import com.trkj.thirdproject.service.SuggestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SuggestContrloller {
    @Autowired
    private SuggestService suggestService;
    @GetMapping("/findAllSuggest")
    public Suggest findAllSuggest(@RequestBody Suggest suggest){
        log.debug("开始显示Suggest");
        suggestService.findAllSuggest();
        return suggest;
    }
    @GetMapping("/findPageSuggest")
    public PageInfo<Suggest> findPageSuggest(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize){
        log.debug("开始分页！");
        PageHelper.startPage(currentPage,pagesize);
        List<Suggest> suggestList=suggestService.findAllSuggest();
        PageInfo<Suggest> suggestPageInfo=new PageInfo<>(suggestList);
        log.debug(suggestList.toString());
        return suggestPageInfo;
    }
    @GetMapping("/findNamePageSuggest")
    public PageInfo<Suggest> findNamePageSuggest(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize,@RequestParam("SuSearch") String Suggest_Name){
        log.debug("开始分页查询！");
        PageHelper.startPage(currentPage,pagesize);
        List<Suggest> suggestList=suggestService.findNameSuggest(Suggest_Name);
        PageInfo<Suggest> suggestPageInfo=new PageInfo<>(suggestList);
        log.debug(suggestList.toString());
        return suggestPageInfo;
    }
    @PostMapping("/AddSuggest")
    public Suggest AddSuggest(@RequestBody Suggest suggest){
        log.debug("开始增加Suggest");
        return suggestService.insertSelective(suggest);
    }
    @PutMapping("/UpdateSuggest")
    public Suggest UpdateSuggest(@RequestBody Suggest suggest){
        log.debug("开始修改Suggest");
        return suggestService.UpdateSuggest(suggest);
    }
    @PutMapping("/DelSuggest")
    public Suggest DelSuggest(@RequestBody Suggest suggest){
        log.debug("开始删除Suggest");
        return suggestService.DelAuggest(suggest);
    }


}
