package com.trkj.thirdproject.controller;

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
    @PutMapping("/delAnn/{multipleSelection}/{name}")
    public int delAnn(@PathVariable("multipleSelection") List<Integer> multipleSelection, @PathVariable("name")String ne){
        Date date=new Date();
        return service.delAnn(multipleSelection,ne,new Date());
    }
}
