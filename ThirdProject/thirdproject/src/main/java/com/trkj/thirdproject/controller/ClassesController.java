package com.trkj.thirdproject.controller;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Classtype;
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
    public PageInfo<Classes> findAllClass(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Classes> entityPage=classesService.findAllclass();
        PageInfo<Classes> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
    @PostMapping("/insertClass")
    @LogginAnnotation(message = "新增班级")
    public Classes insertClass(@RequestBody Classes classes){
        classesService.insert(classes);
        return classes;
    }
    @PutMapping("/updateClass")
    @LogginAnnotation(message = "修改班级")
    public AjaxResponse updateClass(@RequestBody Classes classes){
        classesService.updateByPrimaryKeySelective(classes);
        return AjaxResponse.success("修改成功");
    }
    @GetMapping("/selectByContion")
    public PageInfo<Classes> selectByContion(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize,@RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<Classes> entityPage=classesService.selectByContion(value, input);
        PageInfo<Classes> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
    // 修改为已开班
    @PutMapping("/updateClassesOpen1")
    @LogginAnnotation(message = "修改班级为开班状态")
    public Classes updateClassesOpen1( @RequestBody Classes classes){
        return classesService.updateClassesOpen1(classes);
    }
    // 修改为未开班
    @PutMapping("/updateClassesOpen0")
    @LogginAnnotation(message = "修改班级为未班状态")
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
    public Detailcourse selectDetailCourse( @PathVariable Integer ClassId){
        return classesService.selectDetailCourse(ClassId);
    }
    //    根据id查询班级信息
    @GetMapping("/selectById")
    public  Classes selectById( @RequestParam Integer classesId){
        return classesService.selectById(classesId);
    }
    //给班级赋值课程详细编号
    @PutMapping("/updateDetails")
    public Classes updateDetails(@RequestBody Classes classes){
        return classesService.updateDetails(classes);
    }
    @GetMapping("/selectnotDetails/{classesId}/{serial}")
    public List<Detailcourse> selectnotDetails(@PathVariable("classesId") Integer classesId ,@PathVariable("serial") Integer serial){
        return classesService.selectnotDetails(classesId ,serial);
    }
}
