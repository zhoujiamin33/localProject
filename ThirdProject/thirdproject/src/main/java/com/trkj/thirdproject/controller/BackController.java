package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Back;
import com.trkj.thirdproject.entity.Suspende;
import com.trkj.thirdproject.service.BackService;
import com.trkj.thirdproject.service.SuspendeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class BackController {
    @Autowired
    private BackService backService;
    @Autowired
    private SuspendeService suspendeService;
    @PostMapping("Addback")
    public Back Addback(Back back){
        back=backService.insertSelective(back);
        Suspende suspende=new Suspende();
        suspende.setTimeliness(1);
        suspende.setDeletetime(new Date());
        suspende.setSuspendeId(back.getSuspendeId());
        suspendeService.updateByPrimaryKeySelective(suspende);
        return back;
    }
}
