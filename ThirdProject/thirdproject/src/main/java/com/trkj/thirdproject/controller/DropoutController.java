package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Dropout;
import com.trkj.thirdproject.entity.Studentstatus;
import com.trkj.thirdproject.service.DropoutService;
import com.trkj.thirdproject.service.RefundService;
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
    @Autowired
    private RefundService refundService;
//    根据学员编号修改状态表中的状态，再新增退学表中的数据
    @PostMapping("/Adddropout")
    @LogginAnnotation(message = "新增退学")
    public Dropout adddropout(@RequestBody Dropout dropout,@RequestParam Integer studentstatusId){
        dropout=dropoutService.insertSelective(dropout);
        log.debug(dropout.toString()+"退学");
        Studentstatus studentstatus=new Studentstatus();
        log.debug("sss"+studentstatusId);
        studentstatus.setStatus(2);//退学审核
        studentstatus.setStudentstatusId(studentstatusId);
        studentstatus=studentstatusService.updatestustart(studentstatus);
        log.debug("修改退学状态"+studentstatus.toString());
        return dropout;
    }
//    @PutMapping("/updatetuixue")
//    public Studentstatus updatetuixue(@RequestParam("studentstatusId") Integer studentstatusId){
//        Studentstatus studentstatus=new Studentstatus();
//        log.debug("sss"+studentstatusId);
//        studentstatus.setStatus(2);//退学审核
//        studentstatus.setStudentstatusId(studentstatusId);
//        studentstatus=studentstatusService.updatestustart(studentstatus);
//        return studentstatus;
//    }
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
    @DeleteMapping("/updatedropoutstate")
    @LogginAnnotation(message = "批量审核退学")
    public void updatedropoutstate(@RequestParam("dropoutId") String dropoutId,@RequestParam("jwappname") String jwappname){
        String[] id=dropoutId.split(",");
        for (String d:id){
            Dropout dropout=dropoutService.selectByPrimaryKey(Integer.parseInt(d));
//            dropout.setJwAppname("tsm");
            dropout.setJwApptime(new Date());
            dropout.setJwApproval(1);
            dropout.setJwAppname(jwappname);
            dropoutService.updateByPrimaryKeySelective(dropout);

}

    }
    @DeleteMapping("/deldropouttimeliness")
    @LogginAnnotation(message = "批量删除退学")
    public void deldropouttimeliness(@RequestParam String dropoutId){
        String[] id=dropoutId.split(",");
        for (String d:id){
            Dropout dropout=dropoutService.selectByPrimaryKey(Integer.parseInt(d));
//            dropout.setDeletename("tsm");
            dropout.setDeletetime(new Date());
            dropout.setTimeliness(1);
            dropoutService.updateByPrimaryKeySelective(dropout);
        }

    }
}
