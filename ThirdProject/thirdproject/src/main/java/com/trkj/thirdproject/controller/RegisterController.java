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
    //查询咨询登记表中咨询状态为有意向的数据
    @GetMapping("/selectAttentState")
    public List<Register> selectAttentState(){
        log.debug("查询有意向");
        return registerService.selectAttentState();
    }
    //根据id查询咨询登记
    @GetMapping("/selectByregisterId/{registerId}")
    public Register selectByregisterId(@PathVariable("registerId") int registerId){
//        log.debug("查询有意向");
        return  registerService.selectByregisterId(registerId);
    }
    //修改咨询登记表的缴费状态
    @PutMapping("/updatepaystate/{registerId}")
    public Register updatepaystate(@PathVariable("registerId") Integer  registerId){
        Register register= registerService.updatepaystate(registerId);
        return register;
    }
}
