package com.trkj.thirdproject.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Classtype;
import com.trkj.thirdproject.service.CourseTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;
@Slf4j
@RestController
public class CourseTypeController {
    @Autowired
    private CourseTypeService courseTypeService;

    //模糊查询
    @GetMapping("/findPage")
    public PageInfo<Classtype> findPage(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize,@RequestParam("searchinput") String searchinput){
        PageHelper.startPage(currentPage,pagesize);
        List<Classtype> entityPage=courseTypeService.selectByname(searchinput);
        PageInfo<Classtype> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }


    @GetMapping("/findcoursetype")
    public List<Classtype> findClasstype(){
        log.debug("调用查询所有方法");
        return courseTypeService.selectAllClassType();
    }

    @PostMapping("/addcoursetype")
    @LogginAnnotation(message = "新增课类")
    public Classtype addcoursetype(@RequestBody Classtype classtype){
        log.debug("调用新增方法");
        log.debug(classtype.toString());
        courseTypeService.insert(classtype);
        return classtype;
    }
    @PutMapping("/updateType")
    @LogginAnnotation(message = "修改课类")
    public Classtype updateType(@RequestBody Classtype classtype){
        courseTypeService.updateType(classtype);
        return classtype;
    }
    //没有分页的查询数据
    @GetMapping("/findClassType")
    public List<Classtype> findClassType(){
        return courseTypeService.selectAllClassType();
    }
}
