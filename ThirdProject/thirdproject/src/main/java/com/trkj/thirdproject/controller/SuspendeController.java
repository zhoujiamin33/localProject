package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.entity.Studentstatus;
import com.trkj.thirdproject.entity.Suspende;
import com.trkj.thirdproject.service.StudentstatusService;
import com.trkj.thirdproject.service.SuspendeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class SuspendeController {
    @Autowired
private SuspendeService suspendeService;
    @Autowired
    private StudentstatusService studentstatusService;
    @PostMapping("/addsupende")
    @LogginAnnotation(message = "停课")
    public Suspende addsupende(@RequestParam("studentstatusId") Integer studentstatusId,@RequestBody Suspende suspende){
        suspende= suspendeService.insertSelective(suspende);
        Studentstatus studentstatus=new Studentstatus();
        studentstatus.setSuspendeId(suspende.getSuspendeId());
        studentstatus.setStudentstatusId(studentstatusId);
        studentstatus.setStudentId(suspende.getStudentId());
        studentstatus.setStatus(3);//已停课
        //学员表中查看详情中，点击学员停课，学员状态表中的状态字段为已停课
        studentstatusService.updatestustart(studentstatus);
       return suspende;
    }
//    模糊查询
    @GetMapping("/findAllsuspende")
    public PageInfo<Suspende> findAllsuspende(@RequestParam("index") String index,@RequestParam("value") String value,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询");
        PageHelper.startPage(currentPage,pagesize);
        List<Suspende> suspendeList=suspendeService.findName_number(index, value);
        log.debug("停课："+suspendeList);
        PageInfo<Suspende> suspendeInfo=new PageInfo<>(suspendeList);
        return suspendeInfo;
    }
//    根据学员编号修改学员状态表
@PutMapping("/updatesuspendestate")
    public void updatesuspendestate(@RequestParam("studentId")Integer studentId){
    List<Studentstatus> studentstatus=studentstatusService.selectByPrimaryKey(studentId);
    for(Studentstatus stustate:studentstatus){

        stustate.setStatus(1);//是否重新分班还是直接读
        log.debug("查看停课的状态为1："+stustate);
        studentstatusService.updatestustart(stustate);
    }


}
//    修改状态或者是删除修改时效性
    @DeleteMapping("/updateapprovalsu")
    @LogginAnnotation(message = "批量审核停课")
    public void updateapproval(@RequestParam("suspendeId")String suspendeId,@RequestParam("suspendeSappname")String suspendeSappname){
       String[] id=suspendeId.split(",");
        for (String s:id){
            Suspende suspende=suspendeService.selectByPrimaryKey(Integer.parseInt(s));
            suspende.setSuspendeApproval(1);//审批状态已审核
            suspende.setSuspendeSapptime(new Date());//审批时间
            suspende.setSuspendeSappname(suspendeSappname);
            suspendeService.updateByPrimaryKeySelective(suspende);
        }


    }
    @DeleteMapping("/delsuspend")
    @LogginAnnotation(message = "批量删除停课")
    public void delsuspend(@RequestParam("suspendeId") String suspendeId,@RequestParam("deletename")String deletename){
        String[] id=suspendeId.split(",");
        for (String s:id){
            Suspende suspende=suspendeService.selectByPrimaryKey(Integer.parseInt(s));
            suspende.setTimeliness(1);//时效性为1
            suspende.setDeletetime(new Date());//删除时间
            suspende.setDeletename(deletename);
            suspendeService.updateByPrimaryKeySelective(suspende);
        }


    }


}
