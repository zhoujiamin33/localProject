package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.service.ClassesService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    @GetMapping("/findAllClass")
    public List<Classes> findAllClass(){
        return classesService.findAllclass();
    }
    @PostMapping("/insertClass")
    public Classes insertClass(@RequestBody Classes classes){
        classesService.insert(classes);
        return classes;
    }
    @PutMapping("/updateClass")
    public AjaxResponse updateClass(@RequestBody Classes classes){
        classesService.updateByPrimaryKeySelective(classes);
        return AjaxResponse.success("修改成功");
    }
}
