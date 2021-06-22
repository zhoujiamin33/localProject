package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.*;
import com.trkj.thirdproject.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private MemorandumattachmentDao memorandumattachmentDao;
    @Autowired
    private RegisterDao registerDao;
    @Autowired
    private StudentstatusDao studentstatusDao;//学员状态表
    //    @Autowired
//    private SourceDao sourceDao;
    @Override
    public List<Student> selectAllstudent() {
        log.debug("查询");
        return studentDao.selectAllstudent();
    }

    @Override
    public Memorandumattachment selectregisterID(Integer registerId) {
        return memorandumattachmentDao.selectregisterID(registerId);
    }

    @Override
    public int AddclassesId(Integer classesId, Integer studentId) {
        return  studentDao.AddclassesId(classesId, studentId);
    }

    @Override
    public Studentstatus selecttudentstsatus(Integer studentId) {
        Studentstatus studentstatus=studentstatusDao.selectByPrimaryKey(studentId);
        return studentstatus;
    }

    //查询学员编号
    @Override
    public Student selectstudentId(Integer studentId) {
        Student student=studentDao.selectByPrimaryKey(studentId);
        return student;
    }

    @Override
    public Student addstudent(Student student) {
        log.debug("新增");


        studentDao.addstudent(student);
        return student;
    }
    //删除
    @Override
    public void delstuTimeness(String deletename, Date deletetime,Integer studentId) {

        studentDao.delstuTimeness(deletename, deletetime, studentId);

    }
    //修改
    @Override
    public Student updatestudent(Student student) {
        student.setUpdatename("tsm管理");
        student.setUpdatetime(new Date());
        student.setStudytime(new Date());
        studentDao.updatestudent(student);
        return student;
    }
    //模糊查询根据姓名和电话
    @Override
    public List<Student> slectName(String index,String value) {
        return studentDao.slectName(index, value);
    }

//    @Override
//    public List<Student> slectPhone(String studentPhone) {
//        return studentDao.slectPhone(studentPhone);
//    }



    //查询所有外键表：course（课程表）
//    @Override
//    public Classes findclass(Integer classesId) {
//        return classesDao.selectByPrimaryKey(classesId);
//    }
    //修改学员交接状态：审核状态为已审核
    @Override
    public int updateByPrimaryKeySelective(Memorandumattachment record) {
        return memorandumattachmentDao.updateByPrimaryKeySelective(record);
    }
    //在学员交接表查询咨询登记信息
    @Override
    public List<Memorandumattachment> selectregister() {
        return memorandumattachmentDao.selectregister();
    }

    @Override
    public int insertSelective(Memorandumattachment record) {
//        招生部里查询出已缴费就读的人员；
        List<Register> list=  registerDao.selectPay_AttentState();
        record.setRegister(list);
        return memorandumattachmentDao.insertSelective(record);
    }

    //学员表中查看详情获取课程顾问：根据咨询编号
    @Override
    public Register selectRegister(Integer RegisterId) {
        Register register=registerDao.selectRegister(RegisterId);
        return register;

    }

    //<!--  根据学员表里的班级id查询班级信息：如果没有分班呢？班级记录表李会显示请选择班级-->
    @Override
    public Classes selectByPrimaryKey(Integer classesId) {
        Classes classes= classesDao.selectByPrimaryKey(classesId);
        return classes;
    }




}
