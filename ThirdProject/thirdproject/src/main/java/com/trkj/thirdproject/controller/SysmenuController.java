package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.SysMenu;
import com.trkj.thirdproject.service.SysmenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SysmenuController {
    @Autowired
    private SysmenuService sysmenuService;
    @GetMapping("/findsysmenu")
    public List<SysMenu> findsysmenu(){
        return sysmenuService.selectAllmenu();
    }

}
