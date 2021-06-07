package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.entity.Studentoutstanding;
import com.trkj.thirdproject.service.EntryfeesService;
import com.trkj.thirdproject.service.OutStandingService;
import jdk.nashorn.internal.ir.EmptyNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

//    @PostMapping("/insertEntryFees")
//    public Entryfees insertEntryFees ( @RequestBody Entryfees entryfees){
//        entryfeesService.insertentryfees(entryfees);
//        log.debug("新增报班缴费");
//        return entryfees;
//    }
    //    审核、修改报班缴费
    @PutMapping("/updateapproval")
    public Entryfees updateapproval(@RequestBody Entryfees entryfees){
        entryfeesService.updateapproval(entryfees);
        return entryfees;
    }
    //    撤销审核、修改报班缴费
    @PutMapping("/updateRevokeapproval")
    public Entryfees updateRevokeapproval(@RequestBody Entryfees entryfees){
        entryfeesService.updateRevokeapproval(entryfees);
        return entryfees;
    }
    //删除报班缴费、修改时效性
    @PutMapping("/deleteEntryfees")
    public Entryfees deleteEntryfees(@RequestBody Entryfees entryfees){
        entryfeesService.deleteByPrimaryKey(entryfees);
        return entryfees;
    }
    //--------------------------------------------------欠费补缴-----------------------------------------------------------------------
    @GetMapping("/findAlloutstanding")
    public List<Studentoutstanding> findAlloutstanding(){
        return outStandingService.selectoutonentry();
    }
}
