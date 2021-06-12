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
    //新增报班缴费数据
    @PostMapping("/insertEntry")
    public Entryfees insretEntry(@RequestBody Entryfees entryfees){
        entryfeesService.insertentryfees(entryfees);
        return entryfees;
    }
    //根据id查询返回AjaxResponse
    @GetMapping("/selectByfeeid/{feesId}")
    public AjaxResponse selectByfeeid(@PathVariable("feesId") Integer feesId){
        entryfeesService.selectByfeeid(feesId);
        return AjaxResponse.success("查询成功");
    }
    //根据id查询返回实体类
    @GetMapping("/selectByfeeidtoentry/{feesId}")
    public Entryfees selectByfeeidtoentry(@PathVariable("feesId") Integer feesId){
        Entryfees entryfees= entryfeesService.selectByfeeid(feesId);
        return entryfees;
    }
    //--------------------------------------------------欠费补缴-----------------------------------------------------------------------
    //在报班缴费中查询缴费方式未预交费的数据
    @GetMapping("/findAlloutstanding")
    public List<Studentoutstanding> findAlloutstanding(){
        return outStandingService.selectoutonentry();
    }
    @PostMapping("/insertoutstanding")
    public Studentoutstanding insertoutstanding(@RequestBody Studentoutstanding studentoutstanding){
        outStandingService.insert(studentoutstanding);
        return studentoutstanding;
    }
    @GetMapping("/selectBycontion/{select}/{input}")
    public List<Studentoutstanding> selectBycontion(@Param("select") String select,@Param("input")String input){
        return  outStandingService.selectBycontion(select, input);
    }
    //查询所有欠费补缴数据
    @GetMapping("/selectoutstanding")
    public List<Studentoutstanding> selectoutstanding(){
        return outStandingService.selectoutstanding();
    }
}
