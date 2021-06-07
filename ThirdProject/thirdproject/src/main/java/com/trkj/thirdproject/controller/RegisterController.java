package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Course;

import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.service.CourseService;
import com.trkj.thirdproject.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j

public class RegisterController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private RegisterService registerService;
    @GetMapping("/findAllRegister")
    public List<Register> findAllRegister(){
        return registerService.selectRegister();
    }
    //
    @GetMapping("/findCourse")
    public List<Course> findAllCourse(){
        return courseService.selectAllCourse();
    }
    //新增
    @PostMapping("/AddRegister")
    public Register insertRegister(@RequestBody Register register){
        log.debug(register.toString());
        register=registerService.insert(register);
        return register;
    }
    //修改
    @PutMapping("/updateRegister")
    public Register updateRegister(@RequestBody Register register){
        register=registerService.updateRegister(register);
        return register;
    }

    @PutMapping("/DelReg/{registerId}")
    public int delstuRegTime(@PathVariable("registerId") List<Integer>registerId){
        log.debug("启用");

        String lastupdatename="阿文";
        Date lastupdatetime=new Date();
        return registerService.delstuRegTime(registerId,lastupdatename,lastupdatetime);
    }

}
