package com.trkj.thirdproject.controller;


import com.trkj.thirdproject.entity.Dept;
import com.trkj.thirdproject.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
//查询所有
    @GetMapping("/findalldept")
    public List<Dept> findalldept(){
        return deptService.findallDept();
    }
    //新增
    @PostMapping("/dept")
    public Dept adddept(@RequestBody Dept dept){
        log.debug(dept.toString());
        dept=deptService.adadept(dept);
        return dept;
    }
    //修改
    @PutMapping("/dept")
    public Dept updatedept(@RequestBody Dept dept){
        deptService.updatedept(dept);
        return dept;
    }

    //删除
    @PutMapping("/dept/{deptId}")
    public void deldept(@PathVariable("deptId") Integer deptId){
        log.debug("删除成功");

      String Deletename="tsm管理员";
      Date Deletetime=new Date();
        deptService.updatetimeliness(Deletename,Deletetime,deptId);
    }

}
