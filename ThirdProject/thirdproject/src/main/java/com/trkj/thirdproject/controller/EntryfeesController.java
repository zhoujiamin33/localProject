package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.entity.Studentoutstanding;
import com.trkj.thirdproject.service.EntryfeesService;
import com.trkj.thirdproject.service.OutStandingService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class EntryfeesController {
    @Autowired
    private EntryfeesService entryfeesService;
    @Autowired
    private OutStandingService outStandingService;

    @GetMapping("/findEntryFees")
    public PageInfo<Entryfees> findEntryFees(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<Entryfees> entityPage = entryfeesService.selectKey();
        PageInfo<Entryfees> entryfeesPageInfo = new PageInfo<>(entityPage);
        return entryfeesPageInfo;
    }

    //    审核、修改报班缴费
    @PutMapping("/updateapproval")
    public Entryfees updateapproval(@RequestBody Entryfees entryfees) {
        entryfeesService.updateapproval(entryfees);
        return entryfees;
    }

    //    撤销审核、修改报班缴费
    @PutMapping("/updateRevokeapproval")
    public Entryfees updateRevokeapproval(@RequestBody Entryfees entryfees) {
        entryfeesService.updateRevokeapproval(entryfees);
        return entryfees;
    }

    //删除报班缴费、修改时效性
    @PutMapping("/deleteEntryfees")
    public Entryfees deleteEntryfees(@RequestBody Entryfees entryfees) {
        entryfeesService.deleteByPrimaryKey(entryfees);
        return entryfees;
    }

    //新增报班缴费数据
    @PostMapping("/insertEntry")
    public Entryfees insretEntry(@RequestBody Entryfees entryfees) {
        entryfeesService.insertentryfees(entryfees);
        return entryfees;
    }

    //根据id查询返回AjaxResponse
    @GetMapping("/selectByfeeid/{feesId}")
    public AjaxResponse selectByfeeid(@PathVariable("feesId") Integer feesId) {
        entryfeesService.selectByfeeid(feesId);
        return AjaxResponse.success("查询成功");
    }

    //根据id查询返回实体类
    @GetMapping("/selectByfeeidtoentry/{feesId}")
    public Entryfees selectByfeeidtoentry(@PathVariable("feesId") Integer feesId) {
        Entryfees entryfees = entryfeesService.selectByfeeid(feesId);
        return entryfees;
    }

    //补缴之后，修改累计欠费的值
    @PutMapping("/updateFeesAccumulated")
    public Entryfees updateFeesAccumulated(@RequestBody Entryfees entryfees) {
        entryfeesService.updateFeesAccumulated(entryfees);
        return entryfees;
    }

    //多条件查询
    @GetMapping("/selectBycontionEntry")
    public PageInfo<Entryfees> selectBycontion(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize,
       @PathVariable("ApprovalState") int ApprovalState, @PathVariable("value2") String value2,@PathVariable("input") String input) {
        log.debug("多条件查询");
        PageHelper.startPage(currentPage, pagesize);
        List<Entryfees> entityPage = entryfeesService.selectBycontion(ApprovalState, value2, input);
        PageInfo<Entryfees> entryfeesPageInfo = new PageInfo<>(entityPage);
        return entryfeesPageInfo;

    }

    //--------------------------------------------------欠费补缴-----------------------------------------------------------------------
    //在报班缴费中查询缴费方式未预交费的数据
    @GetMapping("/findAlloutstanding")
    public PageInfo<Studentoutstanding> findAlloutstanding(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<Studentoutstanding> entityPage = outStandingService.selectoutonentry();
        PageInfo<Studentoutstanding> outonentryPageInfo = new PageInfo<>(entityPage);
        return outonentryPageInfo;
    }

    @PostMapping("/insertoutstanding")
    public Studentoutstanding insertoutstanding(@RequestBody Studentoutstanding studentoutstanding) {
        outStandingService.insert(studentoutstanding);
        return studentoutstanding;
    }

    //欠费补缴界面下拉框选择查询
    @GetMapping("/selectBycontion/{select}/{input}")
    public List<Studentoutstanding> selectBycontion(@RequestParam("select") String select, @RequestParam("input") String input) {
        return outStandingService.selectBycontion(select, input);
    }
    //补缴管理界面
    @GetMapping("/selectByContionout/{Approval}/{value1}/{value2}")
    public List<Studentoutstanding> selectByContionout(@PathVariable("Approval") String Approval,
        @PathVariable("value1") String value1,@PathVariable("value2")   String value2){
        return outStandingService.selectByContionout(Approval,value1,value2);
    }


    //查询所有欠费补缴数据
    @GetMapping("/selectoutstanding")
    public PageInfo<Studentoutstanding> selectoutstanding(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<Studentoutstanding> entityPage = outStandingService.selectoutstanding();
        PageInfo<Studentoutstanding> outStandingPageInfo = new PageInfo<>(entityPage);
        return outStandingPageInfo;
    }

    //审核
    @PutMapping("/updateApprovalState")
    public Studentoutstanding updateApprovalState(@RequestBody Studentoutstanding studentoutstanding) {
        outStandingService.updateApprovalState(studentoutstanding);
        return studentoutstanding;
    }

    //撤销审核
    @PutMapping("/updateReApprovalState")
    public Studentoutstanding updateReApprovalState(@RequestBody Studentoutstanding studentoutstanding) {
        outStandingService.updateReApprovalState(studentoutstanding);
        return studentoutstanding;
    }

    //删除
    @PutMapping("/deleteoutstanding")
    public Studentoutstanding deleteoutstanding(@RequestBody Studentoutstanding studentoutstanding) {
        outStandingService.deleteoutstanding(studentoutstanding);
        return studentoutstanding;
    }

    //修改补缴管理的累计欠费
    @PutMapping("/updateAccumulated")
    public Studentoutstanding updateAccumulated(@RequestBody Studentoutstanding studentoutstanding) {
        outStandingService.updateAccumulated(studentoutstanding);
        return studentoutstanding;
    }
}
