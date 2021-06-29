package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
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
    @PostMapping("/addemp")
    @LogginAnnotation(message = "新增员工")
    public Emp addemp(@RequestBody Emp emp){
        log.debug(emp.toString());
        emp.setAddname("tsm管理员");
        emp.setAddtime(new Date());
        emp=empService.insert(emp);
        return emp;
    }
    @DeleteMapping("/delemp")
    @LogginAnnotation(message = "删除员工")
    public String delEmp(@RequestParam("empId") Integer empId){
        empService.delectEmp(empId);
        return "删除成功";
    }
    //修改
    @PutMapping("/updateemp")
    @LogginAnnotation(message = "修改员工")
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
    @PutMapping("/deltimelimeness")
    @LogginAnnotation(message = "批量删除员工")
    public void deltimelimeness(@RequestParam("empId") List<Integer> empId){
        String leavename="tsm管理";
        Date leavetime=new Date();
        empService.delstuTimeness(leavename,leavetime,empId);
    }
    //启动和禁用
    @PutMapping("/updatestate")
    @LogginAnnotation(message = "开启或禁用")
    public void updatestate(@PathVariable("workersstate") Integer workersstate,@PathVariable("empId") List<Integer> empId){
         empService.updatestate(workersstate, empId);
    }
//    已限制
    @GetMapping("/selectyixz")
    public List<Emp> selectyixz(){
        List<Emp> empList=empService.selectByPrimary();
        log.debug(empList.toString());
        return empList;
    }
    //    未限制
    @GetMapping("/selectweixz")
    public List<Emp> selectweixz(){
        List<Emp> empList=empService.selectByPrimarywei();
        log.debug(empList.toString());
        return empList;
    }
//    新增已限制1
    @PutMapping("/updateyxz/{empId}")
    public void updateyxz(@PathVariable("empId")String empId){
        String[] e=empId.split(",");
        for (String Ids:e){
            Emp emp=new Emp();
            emp.setLoginstate(1);//已限制
            emp.setEmpstate(1);//离职
            emp.setEmpId(Integer.parseInt(Ids));
            empService.updateEmp(emp);
        }


    }
//    取消限制未限制0
@PutMapping("/updatewxz/{empId}")
public void updatewxz(@PathVariable("empId")String empId){
    String[] e=empId.split(",");
    for (String Ids:e){
        Emp emp=new Emp();
        emp.setLoginstate(0);//已限制
        emp.setEmpstate(0);//离职
        emp.setEmpId(Integer.parseInt(Ids));
        empService.updateEmp(emp);
    }
}
    @GetMapping("/selectEmpteacher")
    public List<Emp> selectEmpteacher(){
        return empService.selectEmpteacher();
    }
}
