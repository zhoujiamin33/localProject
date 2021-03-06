package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.*;
import com.trkj.thirdproject.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    @Resource
    private ClassesDao classesdao;

    @Override
    public Scheduling insert(Scheduling scheduling) {
        for (int t : scheduling.getPeriods()) {
            log.debug(t + "wwwww");
            for (int cr : scheduling.getClassrooms()) {
                log.debug(cr + "room");
                for (int e : scheduling.getEmps()) {
                    for (int cl : scheduling.getClasslist()) {
                        log.debug(e + "emp");
                        log.debug(t + " " + cr + " " + e + cl + "ghhhhhh");
//                        list.add(t + "-" + cr + "-" + e + "-" + cl +"-"+1 );
                    }
                }
            }
        }
        List<Scheduling> schedulinglist = schedulingdao.selectAllScheduling();
        List<String> sclist = new ArrayList<>();
        for (Scheduling sc : schedulinglist) {
            log.debug(sc.getPeriodId() + "-" + sc.getClassroomId() + "-" + sc.getTeacherId() + "-" + sc.getClassesId());
            sclist.add(sc.getPeriodId() + "-" + sc.getClassroomId() + "-" + sc.getTeacherId() + "-" + sc.getClassesId()+"-"+sc.getDetailcourseId());
        }
        log.debug(sclist.toString() + "==================================");
        return scheduling;
    }

//    @Override
//    public Scheduling insert(Scheduling scheduling) {
//        //新的集合
//        List<String> list = new ArrayList<>();
//
//        for (int t : scheduling.getPeriods()) {
//            log.debug(t + "wwwww");
//            for (int cr : scheduling.getClassrooms()) {
//                log.debug(cr + "room");
//                for (int e : scheduling.getEmps()) {
//                    for (int cl : scheduling.getClasslist()) {
//                        log.debug(e + "emp");
//                        log.debug(t + " " + cr + " " + e + cl + "ghhhhhh");
//                        list.add(t + "-" + cr + "-" + e + "-" + cl +"-"+1 );
//                    }
//                }
//            }
//        }
//        log.debug(list.toString() + "------------------------------------------");
////         得到课程详细编号
////        for (int cl:scheduling.getClasslist()){
////            Classes classes=classesdao.selectById(cl);
////            List<Detailcourse> serial=classesdao.selectSerial(cl,classes.getDetailcourse().getSerial());
////            serial.getClass().
////        }
//
//        //            搜索排课表
//        List<Scheduling> schedulinglist = schedulingdao.selectAllScheduling();
//        List<String> sclist = new ArrayList<>();
//        for (Scheduling sc : schedulinglist) {
//            log.debug(sc.getPeriodId() + "-" + sc.getClassroomId() + "-" + sc.getTeacherId() + "-" + sc.getClassesId());
//            sclist.add(sc.getPeriodId() + "-" + sc.getClassroomId() + "-" + sc.getTeacherId() + "-" + sc.getClassesId()+"-"+sc.getDetailcourseId());
//        }
//        log.debug(sclist.toString() + "==================================");
//
//        //去掉集合中重复的元素
//        List<String> exists = new ArrayList<String>(list);
//        exists.removeAll(sclist);
//        log.debug(exists.toString() + "/////////////////////////////");
//
//
//        log.debug(scheduling.getCoursecount() + "");
//        log.debug(scheduling.getClasslist() + "");
//        int count = scheduling.getCoursecount() * scheduling.getClasslist().size();
//        log.debug(count + "count===");
//
//
//        List<Object> filter1=new ArrayList<>();
//        int i=1;
//        for (String schedul:exists){
//            String[] abc =schedul.split("-");
//            scheduling.setAddtime(new Date());
//            log.debug(schedul+ "vvvvvvvvvvv");
//            log.debug(Integer.parseInt(abc[0]) + "sss"+ Integer.parseInt(abc[1]) + "sss"+ Integer.parseInt(abc[2]) + "sss"+ Integer.parseInt(abc[3]) + "ssssssssss");
//            scheduling.setPeriodId(Integer.parseInt(abc[0]));
//            scheduling.setClassroomId(Integer.parseInt(abc[1]));
//            scheduling.setTeacherId(Integer.parseInt(abc[2]));
//            scheduling.setClassesId(Integer.parseInt(abc[3]));
//            scheduling.setDetailcourseId(Integer.parseInt(abc[4]));
//            if(i<count){
//                schedulingdao.insert(scheduling);
//                exists.remove(Integer.parseInt(abc[0]));
//                exists.remove(Integer.parseInt(abc[1]));
//                exists.remove(Integer.parseInt(abc[2]));
//                exists.remove(Integer.parseInt(abc[3]));
//                exists.remove(Integer.parseInt(abc[4]));
//                log.debug(exists.toString() + "/////////////////////////////");
//                i++;
//                log.debug(i+"wwwwwwwww");
//            }else{
//                break;
//            }
//        }
//
//        return scheduling;
//    }

    @Override
    public List<Scheduling> selectAllScheduling() {
        return schedulingdao.selectAllScheduling();
    }

    @Override
    public Scheduling selectremove(int periodId, String classroomName, String empName) {
        return schedulingdao.selectremove(periodId, classroomName, empName);
    }
}
