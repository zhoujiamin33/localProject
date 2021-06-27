package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Back;
import com.trkj.thirdproject.entity.Studentstatus;
import com.trkj.thirdproject.entity.Suspende;
import com.trkj.thirdproject.service.BackService;
import com.trkj.thirdproject.service.StudentstatusService;
import com.trkj.thirdproject.service.SuspendeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
public class BackController {
    @Autowired
    private BackService backService;
    @Autowired
    private StudentstatusService studentstatusService;
    @PostMapping("/Addback")
//    新增复课数据同时，查询停课中的数据并得出缺课课时，更改学员状态为3、如果复课中的复课意向为0的话就选择班级，如果复课意向为1的话就已分班状态
    public Back Addback(@RequestBody Back back, @RequestParam("studentstatusId") Integer studentstatusId){
        back=backService.insertSelective(back);
        Studentstatus studentstatus=new Studentstatus();
        if (back.getIntention()==0){
            log.debug("zt"+studentstatusId);
            studentstatus.setStudentstatusId(studentstatusId);
            studentstatus.setStatus(back.getIntention());
            studentstatus.setClassesId(null);
            studentstatusService.updatestustart1(studentstatus);
        }else{
            studentstatus.setStudentstatusId(studentstatusId);
            studentstatus.setStatus(back.getIntention());
            studentstatusService.updatestustart(studentstatus);
        }

        return back;
    }
}
