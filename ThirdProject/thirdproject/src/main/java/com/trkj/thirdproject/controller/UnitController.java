package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Unit;
import com.trkj.thirdproject.service.UnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class UnitController {
    @Autowired
    private UnitService unitService;
    @GetMapping("/findAllUnit")
    public List<Unit> findAllUnit(){
        return unitService.findAllUnit();
    }
    @PostMapping("/UnitAdd")
    public Unit AddUnit(@RequestBody Unit unit){
        log.debug("开始添加！");
        log.debug(unit.toString()+"222");
        unitService.UnitAdd(unit);
        return unit;
    }
    @PutMapping("/UpdateUnit")
    public Unit  UpdateUnit(@RequestBody Unit unit){
        log.debug("开始修改！");
        log.debug(unit.getUnitName()+":"+unit.getAddname());
        unitService.UpdateUnit(unit);
        return unit;
    }
    @PutMapping("/delUnit/{multipleSelection}/{nu}")
    public List<Integer> delUnit(@PathVariable("multipleSelection") List<Integer> multipleSelection,@PathVariable("nu")String nu){
        log.debug("开始删除！");
        log.debug(multipleSelection.toString());
        unitService.delUnit(multipleSelection,nu,new Date());

        return multipleSelection;
    }
    @GetMapping("/findPageUnit")
    public PageInfo<Unit> findPage(@RequestParam("currentPage")int currentPage,@RequestParam("pagesize")int pagesize){
        log.debug("开始分页！");
        PageHelper.startPage(currentPage,pagesize);
        List<Unit>unitList=unitService.findAllUnit();
        PageInfo<Unit> unitPageInfo=new PageInfo<>(unitList);
        log.debug(unitList.toString());
        return unitPageInfo;
    }
}
