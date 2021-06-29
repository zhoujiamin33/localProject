package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassroomDao;
import com.trkj.thirdproject.dao.EmpDao;
import com.trkj.thirdproject.dao.SchedulingDao;
import com.trkj.thirdproject.dao.TrainingperiodDao;
import com.trkj.thirdproject.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SchedulingSeviceImpl implements SchedulingSevice {
    @Resource
    private SchedulingDao schedulingdao;
    @Resource
    private TrainingperiodDao perioddao;
    @Resource
    private ClassroomDao classroomdao;
    @Resource
    private EmpDao empdao;

//    @Override
//    public Scheduling insert(Scheduling scheduling) {
//         for(int ps:scheduling.getPeriods()){
//             scheduling.setAddtime(new Date());
//             scheduling.setPeriodId(ps);
//             schedulingdao.insert(scheduling);
//         }
//         return scheduling;
//    }
        @Override
    public Scheduling insert(Scheduling scheduling) {
            //新的集合
            List<String> list=new ArrayList<>();

            for (int t: scheduling.getPeriods()){
                log.debug(t+"wwwww");
                for (int cr :scheduling.getClassrooms()){
                    log.debug(cr+"room");
                    for (int e:scheduling.getEmps()){
                        log.debug(e+"emp");
                        log.debug(t+"-"+cr+"-"+e+"ghhhhhh");
                        list.add(t+"-"+cr+"-"+e+"");
                    }
                }
         }
         log.debug(list.toString()+"------------------------------------------");



            //            搜索排课表
         List<Scheduling> schedulinglist=schedulingdao.selectAllScheduling();
         List<String> sclist=new ArrayList<>();
         for (Scheduling sc:schedulinglist){
            log.debug(sc.getPeriodId()+"-"+sc.getClassroomId()+"-"+sc.getTeacherId());
            sclist.add(sc.getPeriodId()+"-"+sc.getClassroomId()+"-"+sc.getTeacherId());
         }
         log.debug(sclist.toString()+"==================================");

            //去掉集合中重复的元素
         List<String> exists=new ArrayList<String>(list);
         exists.removeAll(sclist);
         log.debug(exists.toString()+"/////////////////////////////");

//         定义一个时段集合：
            List<Integer> keduan=new ArrayList<>();
//            教师集合
            List<Integer> teacher=new ArrayList<>();
//            教室集合
            List<Integer> room=new ArrayList<>();
            //给字段赋值
         log.debug(scheduling.getCoursecount()+"");
         log.debug(scheduling.getClasslist()+"");
         int count=scheduling.getCoursecount()*scheduling.getClasslist().size();
         log.debug(count+"count===");

         for(int i=0;i<count;i++){
             scheduling.setAddtime(new Date());
             for (int classes:scheduling.getClasslist()){
                 scheduling.setClassesId(classes);
//
                 for (String schedul:exists){
                     String[] abc=schedul.split("-");
                     log.debug(schedul+"fff");
                     log.debug(Integer.parseInt(abc[0])+"sss"+Integer.parseInt(abc[1])+"sss"+Integer.parseInt(abc[2])+"sss");
                     keduan.add(Integer.parseInt(abc[0]));
                     teacher.add(Integer.parseInt(abc[1]));
                     room.add(Integer.parseInt(abc[2]));
                 }
                 schedulingdao.insert(scheduling);
             }
            break;
         }
         return scheduling;
    }

    @Override
    public List<Scheduling> selectAllScheduling() {
        return schedulingdao.selectAllScheduling();
    }

    @Override
    public Scheduling selectremove(int periodId,String classroomName,String empName) {
        return  schedulingdao.selectremove(periodId, classroomName, empName);
    }
}
