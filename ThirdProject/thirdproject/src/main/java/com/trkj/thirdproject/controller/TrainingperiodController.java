package com.trkj.thirdproject.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Trainingperiod;
import com.trkj.thirdproject.service.TrainingperiodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TrainingperiodController {
    @Autowired
    private TrainingperiodService trainingperiodService;
    @GetMapping("/findTrainingperiods")
    private List<Trainingperiod> selectAllTrainingperiods(){
        log.debug("Controller方法调用");
        return trainingperiodService.selectAllTrainingperiods();
    }
    @PostMapping("/trainingperiod")
    public Trainingperiod addTrainingperiod(@RequestBody Trainingperiod trainingperiod){
        log.debug(trainingperiod.toString());
        trainingperiodService.addTrainingperiod(trainingperiod);
        return trainingperiod;
    }
    @PutMapping("/trainingperiod")
    public Trainingperiod updateTrainingperiod(@RequestBody Trainingperiod trainingperiod){
        log.debug("开始修改");
        log.debug(trainingperiod.toString());
        trainingperiodService.updateTrainingperiod(trainingperiod);
        return trainingperiod;
    }
    @DeleteMapping("/trainingperiod/{periodId}")
    public String delTrainingperiod(@PathVariable("periodId") int periodId){
        log.debug("开始删除");
        trainingperiodService.delTrainingperiod(periodId);
        return "delOk";
    }

    //分页
    @GetMapping("/findPage2")
    public PageInfo<Trainingperiod> findPage(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Trainingperiod> entityPage=trainingperiodService.selectAllTrainingperiods();
        PageInfo<Trainingperiod> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
