package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.*;

import com.trkj.thirdproject.service.CourseService;
import com.trkj.thirdproject.service.RegisterService;
import com.trkj.thirdproject.service.StudentService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@Slf4j

public class RegisterController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private StudentService studentService;
    @GetMapping("/findAllRegister")
    public List<Register> findAllRegister(){
        return registerService.selectRegister();
    }
    //
    @GetMapping("/findCourse")
    public List<Course> findAllCourse(){
        return courseService.selectAllCourse();
    }
    //新增
    @PostMapping("/AddRegister")

    public Register insertRegister(@RequestBody Register register){
        log.debug(register.toString());
        register=registerService.insert(register);
        return register;
    }
    //修改
    @PutMapping("/updateRegister")
    public Register updateRegister(@RequestBody Register register){
        register=registerService.updateRegister(register);
        return register;
    }
    //批量删除
    @DeleteMapping ("/DelReg")
    public int delstuRegTime(@RequestParam("registerId") List<Integer>registerId){
        log.debug("启用");
        return registerService.delstuRegTime(registerId);
    }
    //查询咨询登记表中咨询状态为有意向的数据
    @GetMapping("/selectAttentState")
    public List<Register> selectAttentState(){
        log.debug("查询有意向");
        return registerService.selectAttentState();
    }
    //根据id查询咨询登记
    @GetMapping("/selectByregisterId")
    public Register selectByregisterId(@RequestParam Integer registerId){
//        log.debug("查询有意向");
        return  registerService.selectByregisterId(registerId);
    }
    //修改咨询登记表的缴费状态
    @DeleteMapping("/updatepaystate")
    public int updatepaystate(@RequestParam("registerId") Integer  registerId){
        return  registerService.updatepaystate(registerId);
    }
    //报表统计中统计每种咨询方式的使用次数
    @GetMapping("/ConsultationmodeStatistics")
    public AjaxResponse ConsultationmodeStatistics(){
         return AjaxResponse.success(registerService.ConsultationmodeStatistics());
    }
    //咨询登记审批
    @GetMapping("/findRegisterId")
    public void findregister(@RequestParam("registerId") String registerId) {
        log.debug(registerId);
        String[] id = registerId.split(",");
        for (String s : id) {
            Memorandumattachment memorandumattachment=new Memorandumattachment();
            memorandumattachment.setRegisterId(Integer.parseInt(s));
            memorandumattachment.setZsexaminename("tsm管理员");
            log.debug("学员交接表新增成功");
            log.debug(s);
            log.debug("学员交接表："+memorandumattachment);
            studentService.insertSelective(memorandumattachment);
            Register register = studentService.selectRegister(Integer.parseInt(s));
            log.debug("咨询登记表："+register);
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

    //咨询登记分页显示
    @GetMapping("/findPageRegister")
    public PageInfo<Register> findPageRegister(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Register> entityPage=registerService.selectAIIRegister();
        PageInfo<Register> registerPageInfo=new PageInfo<>(entityPage);
        return registerPageInfo;
    }

    //咨询登记模糊查询
    @GetMapping("/selectRegisterlivery")
    public PageInfo<Register> selectRegisterlivery(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<Register> entityPage=registerService.selectRegisterlivery(value, input);
        PageInfo<Register> registerPageInfo=new PageInfo<>(entityPage);
        return registerPageInfo;
    }
}
