package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Ideas;
import com.trkj.thirdproject.service.IdeasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class IdeasController {
    @Autowired
    private IdeasService ideasService;

    @GetMapping("/IdeasfindPagesd")
    public PageInfo<Ideas> IdeasfindPagesd(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Ideas> entityPage=ideasService.selectAllsd();
        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @GetMapping("/IdeasfindPagefc")
    public PageInfo<Ideas> IdeasfindPagefc(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Ideas> entityPage=ideasService.selectAllfc();
        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @PutMapping("/updateIdeas")
    public Ideas updateByPrimaryKey(@RequestBody Ideas ideas){
        log.debug("开始修改");
        ideasService.updateByPrimaryKey(ideas);
        return ideas;
    }
}
