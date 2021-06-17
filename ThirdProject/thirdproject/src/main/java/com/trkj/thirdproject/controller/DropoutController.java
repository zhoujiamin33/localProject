package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Dropout;
import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.entity.Studentstatus;
import com.trkj.thirdproject.service.DropoutService;
import com.trkj.thirdproject.service.StudentstatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class DropoutController {
    @Autowired
    private DropoutService dropoutService;
    @Autowired
    private StudentstatusService studentstatusService;
//    根据学员编号修改状态表中的状态，再新增退学表中的数据
    @PostMapping("/Adddropout")
    public Dropout Adddropout(@RequestBody Dropout dropout){
        dropout.setClassesId(dropout.getClassesId());
        dropout.setCourseId(dropout.getCourseId());
        dropout.setStudentId(dropout.getStudentId());
        dropout.setDropHandler("tsm");
        dropout.setDropReason(dropout.getDropReason());
        dropoutService.insertSelective(dropout);
//        Studentstatus studentstatus=studentstatusService.selectByPrimaryKey(dropout.getStudentId());
        Studentstatus studentstatus=new Studentstatus();
        studentstatus.setStudentId(dropout.getStudentId());
        studentstatus.setStatus(2);//退学审核
        studentstatusService.updatestustart(studentstatus);
        return dropout;
    }
//    查询所有退学记录的学员
    @GetMapping("/finddropout")
    public PageInfo<Dropout> finddropout(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询");
        PageHelper.startPage(currentPage,pagesize);
        List<Dropout> dropoutList=dropoutService.selectAlldropout();
        PageInfo<Dropout> dropoutPageInfo=new PageInfo<>(dropoutList);
        return dropoutPageInfo;
    }
//    模糊查询
    @GetMapping("/findcls_stuNameAndxuehao")
    public PageInfo<Dropout> findcls_stuNameAndxuehao(@RequestParam("index") String index,@RequestParam("value") String value,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询");
        PageHelper.startPage(currentPage,pagesize);
        List<Dropout> dropoutList=dropoutService.findclaNmae_stuNameAndxuehao(index, value);
        PageInfo<Dropout> dropoutPageInfo=new PageInfo<>(dropoutList);
        return dropoutPageInfo;
    }
//审批状态的修改和时效性的修改
    @PutMapping("/updatedropoutstate/{dropoutId}")
    public void updatedropoutstate(@PathVariable("dropoutId")String dropoutId){
        String[] id=dropoutId.split(",");
        for (String d:id){
            Dropout dropout=dropoutService.selectByPrimaryKey(Integer.parseInt(d));
            dropout.setJwAppname("tsm");
            dropout.setJwApptime(new Date());
            dropout.setJwApproval(1);
            dropoutService.updateByPrimaryKeySelective(dropout);
}

    }
    @PutMapping("/deldropouttimeliness/{dropoutId}")
    public void deldropouttimeliness(@PathVariable("dropoutId")String dropoutId){
        String[] id=dropoutId.split(",");
        for (String d:id){
            Dropout dropout=dropoutService.selectByPrimaryKey(Integer.parseInt(d));
            dropout.setDeletename("tsm");
            dropout.setDeletetime(new Date());
            dropout.setTimeliness(1);
            dropoutService.updateByPrimaryKeySelective(dropout);
        }

    }
}
