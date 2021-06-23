package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassroomDao;
import com.trkj.thirdproject.dao.EmpDao;
import com.trkj.thirdproject.dao.SchedulingDao;
import com.trkj.thirdproject.dao.TrainingperiodDao;
import com.trkj.thirdproject.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
            //搜索所有的课段
            List<Trainingperiod> periodlist=  perioddao.selectAllTrainingperiods();
            //搜索所有的教室
            List<Classroom> classroomlist=classroomdao.findAllRoom();
            //搜索所有的教师
            List<Emp> emplist= empdao.selectAllEmp();

//            //emplist>periodlist>classroomlist
//            if(emplist.size()>periodlist.size() && emplist.size()>classroomlist.size() && periodlist.size()>classroomlist.size()){
//
//                //classroomlist>emplist>periodlist
//            }else if(emplist.size()>periodlist.size() && emplist.size()<classroomlist.size() ){
//
//            }
//         for(int i=0;i<scheduling.getCoursecount().toString().length();i++){
//
//             for (Trainingperiod t:periodlist){
//                 for(int cl:scheduling.getClasslist()){
//                     scheduling.setAddtime(new Date());
//                     scheduling.setClassesId(cl);
//                     scheduling.setPeriodId(t.getPeriodId());
//                     schedulingdao.insert(scheduling);
//                 }
//             }
//
//         }
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
