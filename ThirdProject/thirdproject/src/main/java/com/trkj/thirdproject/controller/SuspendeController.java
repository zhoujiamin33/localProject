package com.trkj.thirdproject.controller;

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
    public Suspende addsupende(@RequestBody Suspende suspende){
        suspende= suspendeService.insertSelective(suspende);
        Studentstatus studentstatus=new Studentstatus();
        studentstatus.setStudentId(suspende.getStudentId());
        studentstatus.setStatus(3);//已停课
        //学员表中查看详情中，点击学员停课，学员状态表中的状态字段为已停课
        studentstatusService.updatestustart(studentstatus);
       return suspende;
    }
    @GetMapping("/findAllsuspende")
    public List<Suspende> findAllsuspende(){
        List<Suspende> suspendeList=suspendeService.selectAll();
        log.debug("停课："+suspendeList);
        return suspendeList;
    }
//    根据学员编号修改学员状态表
@PutMapping("/updatesuspendestate/{studentId}")
    public Studentstatus updatesuspendestate(@PathVariable("studentId")Integer studentId){
        Studentstatus studentstatus=studentstatusService.selectByPrimaryKey(studentId);
    log.debug("查看停课的状态为1："+studentstatus);
        studentstatus.setStatus(1);
       studentstatusService.updatestustart(studentstatus);
        return studentstatus;
}
//    修改状态或者是删除修改时效性
    @PutMapping("/updateapproval/{suspendeId}")
    public void updateapproval(@PathVariable("suspendeId")String suspendeId){
       String[] id=suspendeId.split(",");
        for (String s:id){
            Suspende suspende=suspendeService.selectByPrimaryKey(Integer.parseInt(s));
            suspende.setSuspendeApproval(1);//审批状态已审核
            suspende.setSuspendeSapptime(new Date());//审批时间
            suspende.setSuspendeSappname("tsm管理员");
            suspendeService.updateByPrimaryKeySelective(suspende);
        }


    }
    @PutMapping("/delsuspend/{suspendeId}")
    public void delsuspend(@PathVariable("suspendeId") String suspendeId){
        String[] id=suspendeId.split(",");
        for (String s:id){
            Suspende suspende=suspendeService.selectByPrimaryKey(Integer.parseInt(s));
            suspende.setTimeliness(1);//时效性为1
            suspende.setDeletetime(new Date());//删除时间
            suspende.setDeletename("tsm管理员");
            suspendeService.updateByPrimaryKeySelective(suspende);
        }


    }

}
