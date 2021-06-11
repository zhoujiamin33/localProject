package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Memorandumattachment;
import com.trkj.thirdproject.entity.Source;
import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;
//    查询
    @GetMapping("/findstudent")
    public PageInfo<Student> findstudent(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询");
        PageHelper.startPage(currentPage,pagesize);
        List<Student> entityPage=studentService.selectAllstudent();
        PageInfo<Student> studentPageInfo=new PageInfo<>(entityPage);
        return studentPageInfo;
    }
//    新增学员
    @PostMapping("/student")
    public Student addstudent(@RequestBody Student student){
        log.debug(student.toString());
        student=studentService.addstudent(student);
        return student;
    }
    //删除学员
    @PutMapping("/student/{studentId}/{deletename}")
    public void deletestudent(@PathVariable("studentId") List<Integer> studentId,@PathVariable("deletename") String deletename){
//        String deletename="tsm管理";
        Date deletetime=new Date();
    studentService.delstuTimeness(deletename, deletetime, studentId);

    }
//修改学员
    @PutMapping("/student")
    public Student updatestudent(@RequestBody Student student){
        log.debug(student.toString());
        student=studentService.updatestudent(student);
        return student;
    }

//    //查询所有值（生源渠道）
//    @GetMapping("/findSource")
//    public List<Source> findSource(){
//
//        return studentService.selectalls();
//    }
    //模糊查询根据姓名和电话
   @GetMapping("/findNameandPhone")
    public List<Student> findNameandPhone(@PathVariable("studentName") String studentName, @PathVariable("studentPhone") String studentPhone){
        return studentService.slectNameAndPhone(studentName, studentPhone);
   }
//    //查询所有外键表：course（课程表）
//    @GetMapping("/findclassall")
//    public List<Classes> findclassall(@RequestParam("classesId") Integer classesId){
//        return studentService.findclass(classesId);
//    }
//    修改学员交接状态：审核状态为已审核
    @PutMapping("/editstate")
    public void editstate(@RequestBody Memorandumattachment record){
        studentService.updateByPrimaryKeySelective(record);
    }
    //根据学员交接查询咨询登记信息:招生审核和教务审核
    @GetMapping("/findallsou")
    public void findall(@RequestParam("memorandumattachmentid") Integer memorandumattachmentid){
        studentService.selectregister(memorandumattachmentid);
    }
    //    新增学员交接表:
    @PostMapping("/Addmentid")
    public void Addmentid(@RequestBody Memorandumattachment record){
        studentService.insertSelective(record);
    }
}
