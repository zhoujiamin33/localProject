package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Announcement;
import com.trkj.thirdproject.service.AnnouncementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        service.AddAnn(announcement);
        return announcement;
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
    @GetMapping("/findPageAnn")
    public PageInfo<Announcement> findPages(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize){
        log.debug("开始分页！");
        PageHelper.startPage(currentPage,pagesize);
        List<Announcement>listann=service.findAllAnn();
        PageInfo<Announcement> unitPageInfo=new PageInfo<>(listann);
        log.debug(listann.toString());
        return unitPageInfo;
    }
}
