package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Emp;
import com.trkj.thirdproject.entity.System;
import com.trkj.thirdproject.entity.Systemtype;
import com.trkj.thirdproject.service.SystemSelectService;
import com.trkj.thirdproject.service.SystemService;
import com.trkj.thirdproject.service.SystemTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class SystemController {
    @Autowired
    private SystemTypeService systemTypeService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private SystemSelectService systemSelectService;
    //查询规章制度类型
    @GetMapping("/findAllSysType")
    public List<Systemtype> findAllSysType(){
        return systemTypeService.findAllSysType();
    }

    @GetMapping("/findAllSystem")
    public PageInfo<System> findAllSystem(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize){
        log.debug("开始分页！");
        PageHelper.startPage(currentPage,pagesize);
        List<System>listSys=systemService.findAllSystem();
        PageInfo<System> SysPageInfo=new PageInfo<>(listSys);
        return SysPageInfo;
    }
//    @GetMapping("/findCanEmpName")
//    public List<System>findCanEmpName() {
//        log.debug("开始查看可查看人!");
//        return systemService.findAllSystem();
//    }
    @PostMapping("/AddSystem")
    public System AddSystem(@RequestBody System system){
        system.setAddtime(new Date());
        systemService.insert(system);
        return system;
    }
    @PostMapping("/AddSystemSelect/{id}/{empId}")
    public Integer AddSystemSelect(@PathVariable("id") int SystemId, @PathVariable("empId") List<Integer> empIds){
        log.debug("传："+empIds);
        for (int EmpId:empIds){
            systemService.AddSystemSelect(SystemId,EmpId);
        }
        log.debug("传："+SystemId);
        return SystemId;
    }
    @GetMapping("/selectEmp")
    public List<Emp>selectEmp() {
        log.debug("开始查看emp");
        return systemService.selectEmp();
    }
    @PutMapping("/delSystem")
    public int delSystem(@RequestBody System system){
        log.debug("开始修改时效性！");
        return systemService.delSystem(system);
    }
    @PutMapping("/UpdateSystem")
    public System UpdateSystem(@RequestBody System system){
        log.debug("开始修改！");
        system.setUpdatetime(new Date());
        return systemService.UpdateSystem(system);
    }
    @PutMapping("/UpdatePublish")
    public System UpdatePublish(@RequestBody System system){
        log.debug("启用！");
        system.setPublishtime(new Date());
        system.setSystemState(1);
        systemService.UpdatePublishSuspend(system);
        return system;
    }
    @PutMapping("/UpdateSuspend")
    public System UpdateSuspend(@RequestBody System system){
        log.debug("禁用！");
        system.setSuspendtime(new Date());
        system.setSystemState(2);
        systemService.UpdatePublishSuspend(system);
        return system;
    }
    @GetMapping("/findConditional")
    public PageInfo<System> findSystem(@RequestParam("currentPage")int currentPage, @RequestParam("pagesize")int pagesize, @RequestParam("index")String index, @RequestParam("value")Object value){
        log.debug("开始查询！");
        log.debug(currentPage+"");
        PageHelper.startPage(currentPage,pagesize);
        List<System>listSys=systemService.findSystem(index,value);
        PageInfo<System> SysPageInfo=new PageInfo<>(listSys);
        log.debug(listSys.toString());
        log.debug(SysPageInfo.getTotal()+"总数");
        return SysPageInfo;
    }

}
