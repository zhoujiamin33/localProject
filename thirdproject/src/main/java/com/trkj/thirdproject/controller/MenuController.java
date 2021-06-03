package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.MenuChildren;
import com.trkj.thirdproject.entity.MenuParent;
import com.trkj.thirdproject.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MenuController {
    @Autowired
    private MenuService childrenService;
    @GetMapping("/findChildren")
    public List<MenuChildren> findChildren(){
        log.debug("进入查询子级方法");
        return childrenService.findChildren();
    }
    @GetMapping("/findParent")
    public List<MenuParent> findParent(){
        log.debug("进入查询父级方法");
        return childrenService.findParent();
    }
}
