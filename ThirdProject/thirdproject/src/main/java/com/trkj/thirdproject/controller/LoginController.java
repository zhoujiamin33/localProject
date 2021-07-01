package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.dao.EmpDao;
import com.trkj.thirdproject.dao.OpjournalDao;
import com.trkj.thirdproject.entity.Emp;
import com.trkj.thirdproject.entity.Opjournal;
import com.trkj.thirdproject.entity.SysMenu;
import com.trkj.thirdproject.service.JwtAuthService;
import com.trkj.thirdproject.service.PermissionService;
import com.trkj.thirdproject.vo.AjaxResponse;
import com.trkj.thirdproject.vo.LoginVo;
import com.trkj.thirdproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private JwtAuthService jwtAuthService;
    @Resource
    private EmpDao empDao;
    @Autowired
    private PermissionService permissionService;
    @Resource
    private OpjournalDao opjournalDao;
    @PostMapping("/login")
    public AjaxResponse login(@RequestBody LoginVo loginVo){
        log.debug("开始验证,{}",loginVo);
        String token=jwtAuthService.login(loginVo.getUsername(),loginVo.getPassword());
        List<SysMenu> menus=permissionService.getMenuByUname(loginVo.getUsername());
        Emp emp = empDao.findByEmpname(loginVo.getUsername());
        Opjournal opjournal=new Opjournal();
        opjournal.setEmpId(emp.getEmpId());
        opjournal.setOpcontent("登录成功");
        opjournalDao.insertSelective(opjournal);
        UserVo vo=new UserVo();
        vo.setId(emp.getEmpId());
        vo.setUsername(loginVo.getUsername());
        vo.setMenus(menus);
        vo.setValidate(true);
        vo.setToken(token);

        return AjaxResponse.success(vo);
    }
    @PostMapping("/signout")
    public AjaxResponse signout(){
        log.debug("开始退出操作");
        AjaxResponse ajaxResponse=AjaxResponse.success("已退出");
        SecurityContextHolder.clearContext();
        return ajaxResponse;
    }
    @PostMapping("/addopjournal")
    @LogginAnnotation(message = "登录完成")
    public int addopjournal(@RequestBody LoginVo loginVo){
        Emp emp = empDao.findByEmpname(loginVo.getUsername());
        Opjournal opjournal=new Opjournal();
     opjournal.setEmpId(emp.getEmpId());
     log.debug(opjournal.toString());
        return opjournalDao.insertSelective(opjournal);
    }
}
