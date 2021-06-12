package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Emp;
import com.trkj.thirdproject.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/findAllEmp")
    public PageInfo<Emp> findAllEmp(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Emp> entityPage=empService.selectAllEmp();
        PageInfo<Emp> empPageInfo=new PageInfo<>(entityPage);
        return empPageInfo;
    }
    //没有分页的查询所有员工
    @GetMapping("/findEmp")
    public List<Emp> findEmp(){
        return empService.selectAllEmp();
    }
    @PostMapping("/emp")
    public Emp Addemp(@RequestBody Emp emp){
        log.debug(emp.toString());
        emp.setAddname("tsm管理员");
        emp.setAddtime(new Date());
        emp=empService.insert(emp);
        return emp;
    }
    @DeleteMapping("/emp/{empId}")
    public String delEmp(@PathVariable("empId") Integer empId){
        empService.delectEmp(empId);
        return "删除成功";
    }
    //修改
    @PutMapping("/emp")
    public Emp updateEmp(@RequestBody Emp emp){
        emp.setUpdatename("tsm管理员");
        emp.setUpdatetime(new Date());
        emp=empService.updateEmp(emp);
        return emp;
    }
    //模糊查询
    @GetMapping("/findalls")
    public PageInfo<Emp> findalls(@RequestParam("index") String index, @RequestParam("value") String value,@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Emp> entityPage=empService.findalls(index,value);
        PageInfo<Emp> empPageInfo=new PageInfo<>(entityPage);
        return empPageInfo;

    }
    //批量删除
    @PutMapping("/deltimelimeness/{empId}")
    public void deltimelimeness(@PathVariable("empId") List<Integer> empId){
        String leavename="tsm管理";
        Date leavetime=new Date();
        empService.delstuTimeness(leavename,leavetime,empId);
    }
    //启动和禁用
    @PutMapping("/updatestate/{workersstate}/{empId}")
    public void updatestate(@PathVariable("workersstate") Integer workersstate,@PathVariable("empId") List<Integer> empId){
         empService.updatestate(workersstate, empId);
    }

}
