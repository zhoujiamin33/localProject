package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Scheduling;
import com.trkj.thirdproject.service.SchedulingSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SchedulingController {
    @Autowired
    private SchedulingSevice schedulingSevice;
    @PostMapping("/insert")
    public Scheduling insert(@RequestBody Scheduling scheduling){
        schedulingSevice.insert(scheduling);
        return scheduling;
    }
}
