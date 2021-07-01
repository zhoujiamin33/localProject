package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Announcement;
import com.trkj.thirdproject.entity.System;
import com.trkj.thirdproject.service.AnnouncementService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class AnnouncementController {
    @Autowired
    private AnnouncementService service;
    @GetMapping("/findAllAnn")
    public List<Announcement> findAllAnn(){
        return service.findAllAnn();
    }
    @PostMapping("/AnnAdd")
    public Announcement AnnAdd(@RequestBody Announcement announcement){
        log.debug("开始添加");
        log.debug("测试：：："+announcement.toString());
        service.AddAnn(announcement);
        return announcement;
    }

    @DeleteMapping("/AddAnnSelect")
    public int AddAnnSelect(@RequestParam("id")int aid, @RequestParam("yesemp")String eids){
        log.debug("开始添加可查看人");
        String[] str= eids.split("&");
        log.info(eids);
        int i=0;
        for(String s:str){
            String[] ss=s.split("=");
            for (String sss:ss){
                if(i != Integer.parseInt(sss)){
                    service.AddAnnSelect(aid,Integer.parseInt(sss));
                }
            }
            i++;
        }

        return aid;
    }

    @PutMapping("/AnnUpdate")
    public Announcement AnnUpdate(@RequestBody Announcement announcement){

        return service.UpdateAnn(announcement);
    }
    @PutMapping("/delAnn")
    public int delAnn(@RequestBody Announcement announcemen){
        return service.delAnn(announcemen);
    }
    @PutMapping("/AnnState")
    public Announcement AnnState( @RequestBody Announcement announcement){
        log.debug("启用");
        announcement.setAnnouncementState(1);
        announcement.setPublishtime(new Date());
        return service.AnnState(announcement);
    }
    @PutMapping("/SuspendAnn")
    public Announcement SuspendAnn( @RequestBody Announcement announcement){
        log.debug("暂停");
        announcement.setAnnouncementState(2);
        announcement.setStartTime(new Date());
        return service.AnnState(announcement);
    }
    //可以不用，用findVariedAnn
    @GetMapping("/selectPageAnn")
    public PageInfo<Announcement> findPages(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize){
        log.debug("开始分页！");
        PageHelper.startPage(currentPage,pagesize);
        List<Announcement>listann=service.findAllAnn();
        PageInfo<Announcement> unitPageInfo=new PageInfo<>(listann);
        log.debug(listann.toString());
        return unitPageInfo;
    }
    @GetMapping("/findVariedAnn")
    public PageInfo<Announcement> findVariedAnn(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize,@RequestParam("AnnSearch")String name){
        log.debug("开始查询分页！");
        PageHelper.startPage(currentPage,pagesize);
        List<Announcement>listann=service.findVaried(name);
        PageInfo<Announcement> AnnPageInfo=new PageInfo<>(listann);
        return AnnPageInfo;
    }
    @GetMapping("/findAnns")
    public PageInfo<Announcement> findAnns(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize,@RequestParam("AnnSearch")String name){
        log.debug("开始分页22222！");
        PageHelper.startPage(currentPage,pagesize);
        List<Announcement>listann=service.selectAnns(name);
        PageInfo<Announcement> AnnPageInfo=new PageInfo<>(listann);
        return AnnPageInfo;
    }
    //首页查询公告类型
    @GetMapping("/findIdAnn")
    public List<Announcement> findIdAnn(@RequestParam("id")  int id){
        return service.findIdAnn(id);
    }


}
