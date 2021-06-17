package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Source;

import com.trkj.thirdproject.service.SourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SourceController {
    @Autowired
    private SourceService sourceService;
    //查询所有值（生源渠道）
    @GetMapping("/findSource")
    public List<Source>selectAIISources(){
        log.debug("Controller 方法调用");
        return sourceService.selectAIISources();
    }
    //新增
    @PostMapping("/AddSource")
    public Source addSource(@RequestBody Source source){
        log.debug(source.getAddname()+"-------");
        source=sourceService.addSource(source);
        return source;
    }
    @PutMapping("/UpSource")
    public Source updateSource(@RequestBody Source source){
        log.debug("开始修改");
        log.debug(source.toString());
        source=sourceService.updateSource(source);
        return source;
    }
    //分页
    @GetMapping("/findPageSource")
    public PageInfo<Source> findPageFaq(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Source> entityPage=sourceService.selectAIISources();
        PageInfo<Source> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
