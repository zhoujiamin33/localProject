package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
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

    @GetMapping("/findIdeasPagesd")
    public PageInfo<Ideas> findIdeasPagesd(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Ideas> entityPage=ideasService.selectAllsd();
        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    @GetMapping("/findIdeasPagefc")
    public PageInfo<Ideas> findIdeasPagefc(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Ideas> entityPage=ideasService.selectAllfc();
        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

//    @GetMapping("/IdeasfindPageqb")
//    public PageInfo<Ideas> IdeasfindPageqb(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
//        PageHelper.startPage(currentPage,pagesize);
//        List<Ideas> entityPage=ideasService.selectAllqb();
//        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
//        return classtypePageInfo;
//    }
//
//    @GetMapping("/IdeasfindPagedhf")
//    public PageInfo<Ideas> IdeasfindPagedhf(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
//        PageHelper.startPage(currentPage,pagesize);
//        List<Ideas> entityPage=ideasService.selectAlldhf();
//        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
//        return classtypePageInfo;
//    }
//
//    @GetMapping("/IdeasfindPageyhf")
//    public PageInfo<Ideas> IdeasfindPageyhf(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
//        PageHelper.startPage(currentPage,pagesize);
//        List<Ideas> entityPage=ideasService.selectAllyhf();
//        PageInfo<Ideas> classtypePageInfo=new PageInfo<>(entityPage);
//        return classtypePageInfo;
//    }

    @PutMapping("/updateIdeas")
    @LogginAnnotation(message = "?????????????????????")
    public Ideas updateByPrimaryKey(@RequestBody Ideas ideas){
        log.debug("????????????");
        ideasService.updateByPrimaryKey(ideas);
        return ideas;
    }

    @PutMapping("/updateIdeasneirong")
    @LogginAnnotation(message = "??????????????????")
    public Ideas updateneirong(@RequestBody Ideas ideas){
        log.debug("????????????");
        ideasService.updateneirong(ideas);
        return ideas;
    }

    @DeleteMapping("/delIdeas")
    @LogginAnnotation(message = "????????????????????????")
    public String delIdeas(@RequestParam int ideasId){
        log.debug("????????????");
        ideasService.deleteByPrimaryKey(ideasId);
        return "delOk";
    }

    @PostMapping("/addIdeas")
    @LogginAnnotation(message = "????????????")
    public Ideas insert(@RequestBody Ideas ideas){
        ideasService.insert(ideas);
        return ideas;
    }
}
