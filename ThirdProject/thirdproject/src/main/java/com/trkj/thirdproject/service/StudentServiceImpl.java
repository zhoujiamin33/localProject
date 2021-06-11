package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassesDao;
import com.trkj.thirdproject.dao.MemorandumattachmentDao;
import com.trkj.thirdproject.dao.SourceDao;
import com.trkj.thirdproject.dao.StudentDao;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Memorandumattachment;
import com.trkj.thirdproject.entity.Source;
import com.trkj.thirdproject.entity.Student;
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
//    @Autowired
//    private SourceDao sourceDao;
    @Override
    public List<Student> selectAllstudent() {
        log.debug("查询");
        return studentDao.selectAllstudent();
    }

    @Override
    public Student addstudent(Student student) {
        log.debug("新增");
        student.setStudentNumber("c00"+student.toString().length()+1);
        studentDao.addstudent(student);
        return student;
    }
//删除
    @Override
    public void delstuTimeness(String deletename, Date deletetime, List<Integer>  studentId) {
for (Integer c:studentId) {
    studentDao.delstuTimeness(deletename, deletetime, c);
}
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
    public List<Student> slectNameAndPhone(String Name, String Phone) {
        return studentDao.slectNameAndPhone(Name, Phone);
    }
//修改学员交接状态：审核状态为已审核
    @Override
    public int updateByPrimaryKeySelective(Memorandumattachment record) {
        return memorandumattachmentDao.updateByPrimaryKeySelective(record);
    }
//根据学员交接查询咨询登记信息
    @Override
    public List<Memorandumattachment> selectregister(Integer memorandumattachmentid) {
        return memorandumattachmentDao.selectregister(memorandumattachmentid);
    }

    @Override
    public int insertSelective(Memorandumattachment record) {
        return memorandumattachmentDao.insertSelective(record);
    }

//    //查询所有值（生源渠道）
//    @Override
//    public List<Source> selectalls() {
//        return sourceDao.selectAIISources();
//    }
}
