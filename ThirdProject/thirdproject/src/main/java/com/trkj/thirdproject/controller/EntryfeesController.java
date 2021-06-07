package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.entity.Studentoutstanding;
import com.trkj.thirdproject.service.EntryfeesService;
import com.trkj.thirdproject.service.OutStandingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EntryfeesController {
    @Autowired
    private EntryfeesService entryfeesService;
    @Autowired
    private OutStandingService outStandingService;
    @GetMapping("/findEntryFees")
    public PageInfo<Entryfees> findEntryFees(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage, pagesize);
        List<Entryfees> entityPage=entryfeesService.selectKey();
        PageInfo<Entryfees> entryfeesPageInfo=new PageInfo<>(entityPage);
        return entryfeesPageInfo;
    }

    @PostMapping("/insertEntryFees")
    public Entryfees insertEntryFees(Entryfees entryfees){
        entryfeesService.insertentryfees(entryfees);
        log.debug("新增报班缴费");
        return entryfees;
    }
    //--------------------------------------------------欠费补缴-----------------------------------------------------------------------
    @GetMapping("/findAlloutstanding")
    public List<Studentoutstanding> findAlloutstanding(){
        return outStandingService.selectoutonentry();
    }
}
