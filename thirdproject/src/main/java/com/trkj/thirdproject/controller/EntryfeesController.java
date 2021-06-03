package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.service.EntryfeesService;
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
}
