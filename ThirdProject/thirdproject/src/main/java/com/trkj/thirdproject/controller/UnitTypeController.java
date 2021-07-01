package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Unittype;
import com.trkj.thirdproject.service.UnitService;
import com.trkj.thirdproject.service.UnitTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UnitTypeController {
    @Autowired
    private UnitTypeService unitTypeService;
    @Autowired
    private UnitService unitService;
    @GetMapping("/selectUnitTypeAll")
    public List<Unittype> findUnitType(){
        log.debug("开始显示UnitType");
        return unitTypeService.selectAllUnitType();
    }
    @PostMapping("/UnitTypeAdd")
    public Unittype UnitTypeAdd(@RequestBody Unittype unittype){
        unitTypeService.UnitTypeAdd(unittype);
        return unittype;
    }
    @PutMapping("/UnitTypeUpdate")
    public Unittype UnitTypeUpdate(@RequestBody Unittype unittype){
        log.debug("开始修改UnitType");
        unitTypeService.UnitTypeUpdate(unittype);
        return unittype;
    }
    @DeleteMapping("/UnitTypeDelete")
    public String UnitTypeDelete(@PathVariable("unittypeId") int unittypeId){
        log.debug("开始删除！");
        unitTypeService.UnitTypeDelete(unittypeId);
        return "删除成功!";
    }
    @PutMapping("/updateTimeLiness")
    public Unittype updateTimeLiness(@RequestBody Unittype unittype){
        unitTypeService.updateTimeLiness(unittype);
        return unittype;
    }
    @GetMapping("/findUnitType")
    public int findUnitType(@RequestParam("unittypeId") int id){
        log.debug(id+"");
        return unitService.fandUnitTypeId(id);
    }
}
