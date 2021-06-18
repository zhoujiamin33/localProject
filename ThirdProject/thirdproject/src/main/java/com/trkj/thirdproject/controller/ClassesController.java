package com.trkj.thirdproject.controller;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
import com.trkj.thirdproject.service.ClassesService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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
    @GetMapping("/selectByContion/{value}/{input}")
    public List<Classes> selectByContion(@PathVariable("value") String value, @PathVariable("input") String input){
        return classesService.selectByContion(value, input);
    }
    // 修改为已开班
    @PutMapping("/updateClassesOpen1")
    public Classes updateClassesOpen1( @RequestBody Classes classes){
        return classesService.updateClassesOpen1(classes);
    }
    // 修改为未开班
    @PutMapping("/updateClassesOpen0")
    public Classes updateClassesOpen0( @RequestBody Classes classes){
        return classesService.updateClassesOpen0(classes);
    }
    //查询班级状态为已开班的班级
    @GetMapping("/selectOpen")
    public List<Classes> selectOpen(){
        return classesService.selectOpen();
    }
    //根据班级id查询班级详细课程进度
    @GetMapping("/selectDetailCourse")
    public List<Detailcourse> selectDetailCourse(){
        return classesService.selectDetailCourse();
    }
    //    根据id查询班级信息
    @GetMapping("/selectById/{classesId}")
    public  Classes selectById( @PathVariable("classesId") Integer classesId){
        return classesService.selectById(classesId);
    }
    //给班级赋值课程详细编号
    @PutMapping("/updateDetails")
    public Classes updateDetails( @RequestBody Classes classes){
        return classesService.updateDetails(classes);
    }
    @GetMapping("/selectnotDetails/{classesId}/{serial}")
    public List<Detailcourse> selectnotDetails(@PathVariable("classesId") Integer classesId ,@PathVariable("serial") Integer serial){
        return classesService.selectnotDetails(classesId ,serial);
    }
}
