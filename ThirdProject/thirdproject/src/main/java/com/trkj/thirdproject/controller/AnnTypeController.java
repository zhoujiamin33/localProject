package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Announcementtype;
import com.trkj.thirdproject.service.AnnTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AnnTypeController {
    @Autowired
    private AnnTypeService annTypeService;
    @GetMapping("/findAnnType")
    public List<Announcementtype> findAnnType(){
        log.debug("开始显示Announcementtype");
        return annTypeService.selectAllType();
    }
    @GetMapping("/findDelType")
    public List<Announcementtype> findDelType(){
        log.debug("开始显示Announcementtype");
        return annTypeService.selectDelAnnType();
    }
    @PostMapping("/AnnTypeAdd")
    public Announcementtype AnnTypeAdd(@RequestBody Announcementtype announcementtype){
        annTypeService.AnnTypeAdd(announcementtype);
        return announcementtype;
    }
    @PutMapping("/AnnTypeUpdate")
    public Announcementtype AnnTypeUpdate(@RequestBody Announcementtype announcementtype){
        log.debug("开始修改UnitType");
        annTypeService.AnnTypeUpdate(announcementtype);
        return announcementtype;
    }
    @PutMapping("/AnnTypeDel")
    public Announcementtype AnnTypeDel(@RequestBody Announcementtype announcementtype){
        log.debug("开始修改UnitType");
        annTypeService.updateTimeLiness(announcementtype);
        return announcementtype;
    }
    @DeleteMapping("/DelAnn/{id}")
    public int DelAnn(int id){
        return annTypeService.AnnTypeDelete(id);
    }
}
