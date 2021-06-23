package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.*;
import com.trkj.thirdproject.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class StudentController {
    //    学员交接
    @Autowired
    private StudentService studentService;
    //    咨询登记
    @Autowired
    private RegisterService registerService;
    //    学员状态表
    @Autowired
    private StudentstatusService studentstatusService;
    //    生源渠道
    @Autowired
    private SourceService sourceService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SupplementaryService supplementaryService;
    //    查询
    @GetMapping("/selectAllclass")
    public PageInfo<Student> findstudent(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询");
        PageHelper.startPage(currentPage,pagesize);
        List<Student> entityPage=studentService.selectAllstudent();
        PageInfo<Student> studentPageInfo=new PageInfo<>(entityPage);
        return studentPageInfo;
    }

    //查询班级表中的值
    @GetMapping("/findClassId/{classesId}")
    public Classes findClassId(@PathVariable("classesId") Integer classesId){
        log.debug("开始查询");
        Classes classes= studentService.selectByPrimaryKey(classesId);
        return classes;
    }
    //删除学员
    @PutMapping("/student/{studentId}/{deletename}")
    public void deletestudent(@PathVariable("studentId") List<Integer> studentId, @PathVariable("deletename") String deletename) {
//        String deletename="tsm管理";
        for(Integer id:studentId) {
            Date deletetime = new Date();
            studentService.delstuTimeness(deletename, deletetime, id);
        }

    }

    //修改学员
    @PutMapping("/student")
    public Student updatestudent(@RequestBody Student student) {
        log.debug(student.toString());
        student = studentService.updatestudent(student);
        return student;
    }

    //    //查询所有值（生源渠道）
//    @GetMapping("/findSource")
//    public List<Source> findSource(){
//
//        return studentService.selectalls();
//    }
//模糊查询根据姓名和电话Student_State
    @GetMapping("/findName")
    public PageInfo<Student> findName(@RequestParam("index") String index, @RequestParam("value") String value, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize) {
        PageHelper.startPage(currentPage, pagesize);
        List<Student> entityPage = studentService.slectName(index, value);
        PageInfo<Student> studentPageInfo = new PageInfo<>(entityPage);
        log.debug("学员表："+entityPage.toString());
        return studentPageInfo;
    }

    //    //查询所有外键表：course（课程表）
//    @GetMapping("/findclassall")
//    public Classes findclassall(@RequestParam("classesId") Integer classesId){
//        return studentService.findclass(classesId);
//    }
    //   新增学员交接表:点击咨询登记审核通过后显示到学员表中，获取交接表咨询登记的编号
    @PostMapping("/Addmentid")
    public void Addmentid(@RequestBody Memorandumattachment record) {
//        显示所有登记记录信息
        record.setZsexaminename("tsm管理员");
        studentService.insertSelective(record);

    }

    //    修改学员交接状态：审核状态为已审核，交接给教务部的进行审核
    @PutMapping("/editstate")
    public void editstate(@RequestBody Memorandumattachment record) {
        studentService.updateByPrimaryKeySelective(record);
    }

    //在学员交接表查询咨询登记信息:招生审核和教务审核
    @GetMapping("/findallsou")
    public void findmemorandumattachment() {
        studentService.selectregister();
    }


    //学员表中查看详情获取咨询登记记录中:
    @GetMapping("/findregisterId/{registerId}")
    public void findregister(@PathVariable("registerId") String registerId) {
        log.debug(registerId);
        String[] id = registerId.split(",");

        for (String s : id) {
//            Memorandumattachment memorandumattachment=new Memorandumattachment();
//            memorandumattachment.setRegisterId(Integer.parseInt(s));
//            memorandumattachment.setZsexaminename("tsm管理员");
            log.debug("学员交接表新增成功");
            log.debug(s);
//            studentService.insertSelective(memorandumattachment);
            Register register = studentService.selectRegister(Integer.parseInt(s));
            Student student = new Student();
            student.setStudentName(register.getConsultant());
            student.setStudentPhone(register.getPhone());
            student.setSex(register.getSex());
            student.setRegisterId(register.getRegisterId());
            student.setSourceId(register.getSourceId());
            student.setStudentNumber("c00" + Integer.parseInt(s));
            log.debug(register.getSex());
            log.debug("学员表新增成功");
            log.debug(student.toString());
            studentService.addstudent(student);
        }

    }

    //学员表查询学员编号
    @GetMapping("/findstudentId/{studentId}")
    public Studentstatus findstudentId(@PathVariable("studentId") Integer studentId) {
        Student student = studentService.selectstudentId(studentId);

        log.debug("学员表中的班级编号：" + student.toString());

            Register register=studentService.selectRegister(student.getRegisterId());//查询咨询登记查询课程表
            Studentstatus studentstatus=new Studentstatus();
            studentstatus.setCourseId(register.getCourseId());//课程编号:显示课程的名称
            studentstatus.setStudentId(studentId);
            studentstatus.setClassesId(student.getClassesId());//班级编号：显示已报班级还是未报班级
        studentstatus.setSignuptime(new Date());
            studentstatusService.AddStudentstatus(studentstatus);//新增学员状态表
        Memorandumattachment memorandumattachment=studentService.selectregisterID(student.getRegisterId());//学员交接表的教务状态改为1已审核
memorandumattachment.setJwexaminename("tsm管理员");
memorandumattachment.setJwexaminetime(new Date());
memorandumattachment.setJwisexamine(1);
studentService.updateByPrimaryKeySelective(memorandumattachment);
        return studentstatus;

    }
//    查询学员
@GetMapping("/findstudentclasses/{studentId}")
public Student findstudentclasses(@PathVariable("studentId") Integer studentId) {
    Student student= studentService.selectstudentId(studentId);
    return student;
}
//    没有添加班级外键的学员表与学员状态表学生选择班级点击保存;该学员添加班级并学员状态表中的状态为已分班1
    @PutMapping("/addclassesId/{classesId}/{studentId}")
    public void addclasses(@PathVariable("classesId") Integer classesId,@PathVariable("studentId")Integer studentId){
        List<Studentstatus> studentstatus=studentstatusService.selectstu_class(studentId);
       log.debug(classesId+"dfd");
       for(Studentstatus s:studentstatus){
           s.setClassesId(classesId);
           s.setStatus(1);//已分班
           studentstatusService.updateByPrimaryKeySelective(s);
       }
        studentService.AddclassesId(classesId, studentId);
        log.debug("学员状态修改"+studentstatus);
    }
//    根据课程编号查询所有
    @GetMapping("/findclasstypeId/{classtypeId}")
    public  List<Course> findclasstypeId(@PathVariable("classtypeId")Integer classtypeId){
        List<Course> course= courseService.selectByCourseTypeId(classtypeId);
        log.debug("类别："+course);
        return course;
    }
//    添加预报课程
    @PostMapping("/AddSupplementary")
    public Supplementary AddSupplementary(@RequestBody Supplementary supplementary){
        log.debug("开始新增");
        supplementary=supplementaryService.insertSelective(supplementary);
        Student student=studentService.selectstudentId(supplementary.getStudentId());
        log.debug("课程详细："+supplementary.toString());
        Studentstatus studentstatus=new Studentstatus();
        studentstatus.setCourseId(supplementary.getCourseId());//课程编号:显示课程的名称
        studentstatus.setStudentId(supplementary.getStudentId());
//        studentstatus.setClassesId(.getClassesId());//班级编号：显示已报班级还是未报班级
        studentstatus.setSignuptime(new Date());
        log.debug("学员状态表："+studentstatus.toString());
        studentstatusService.AddStudentstatus(studentstatus);//新增学员状态表
        log.debug("学员交接表："+studentstatus);
        return supplementary;
    }
    @PostMapping("/AddDetailsupplementary")
    public Detailsupplementary AddDetailsupplementary(@RequestBody Detailsupplementary detailsupplementary){
        detailsupplementary=supplementaryService.insertSelective(detailsupplementary);
        log.debug("课程详细："+detailsupplementary.toString());

        return detailsupplementary;

    }
//    查看补报课程
    @GetMapping("/findsupplementary")
    public  PageInfo<Supplementary> findsupplementary(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("查询补报课程");
        PageHelper.startPage(currentPage,pagesize);
        List<Supplementary> supplementaryList=supplementaryService.selectall();
        PageInfo<Supplementary> suspendeInfo=new PageInfo<>(supplementaryList);
        log.debug(supplementaryList.toString());
        return suspendeInfo;
    }
//    审核修改审核状态
    @PutMapping("/updatesupplementarystate/{supplementaryId}")
    public void updatesupplementarystate(@PathVariable("supplementaryId")String supplementaryId ){
        String[] id=supplementaryId.split(",");
        for (String s:id){
        Supplementary supplementary=new Supplementary();
        supplementary.setUpdatename("tsm");
        supplementary.setUpdatetime(new Date());
        supplementary.setState(1);
        supplementary.setSupplementaryId(Integer.parseInt(s));
        supplementary=supplementaryService.updateByPrimaryKeySelective(supplementary);

        }
    }
//    取消补报
    @PutMapping("/updatesupplementarystate0/{supplementaryId}")
    public void updatesupplementarystate0(@PathVariable("supplementaryId")String supplementaryId ){
        String[] id=supplementaryId.split(",");
        for (String s:id){
            Supplementary supplementary=new Supplementary();
            supplementary.setUpdatename("tsm");
            supplementary.setUpdatetime(new Date());
            supplementary.setState(0);
            supplementary.setSupplementaryId(Integer.parseInt(s));
            supplementary=supplementaryService.updateByPrimaryKeySelective(supplementary);

        }
    }
//    删除时效性
    @PutMapping("/updatesupplementaryTimeliness/{supplementaryId}")
    public void updatesupplementaryTimel(@PathVariable("supplementaryId")String supplementaryId ){
        String[] id=supplementaryId.split(",");
        for (String s:id){
            Supplementary supplementary=new Supplementary();
            supplementary.setDeletename("tsm");
            supplementary.setDeletetime(new Date());
            supplementary.setTimeliness(1);
            supplementary.setSupplementaryId(Integer.parseInt(s));
            supplementary=supplementaryService.updateByPrimaryKeySelective(supplementary);
        }


    }
    //根据班级id查询学员
    @GetMapping("/selectByClass/{classesId}")
    public List<Student> selectByClass( @PathVariable("classesId") Integer classesId){
        return studentService.selectByClass(classesId);
    }
}