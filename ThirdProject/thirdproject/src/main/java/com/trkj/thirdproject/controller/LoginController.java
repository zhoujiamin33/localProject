package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.SysMenu;
import com.trkj.thirdproject.service.JwtAuthService;
import com.trkj.thirdproject.service.PermissionService;
import com.trkj.thirdproject.vo.AjaxResponse;
import com.trkj.thirdproject.vo.LoginVo;
import com.trkj.thirdproject.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private JwtAuthService jwtAuthService;
    @Autowired
    private PermissionService permissionService;
    @PostMapping("/login")
    public AjaxResponse login(@RequestBody LoginVo loginVo){
        log.debug("开始验证,{}",loginVo);
        String token=jwtAuthService.login(loginVo.getUsername(),loginVo.getPassword());
        List<SysMenu> menus=permissionService.getMenuByUname(loginVo.getUsername());
        UserVo vo=new UserVo();
        vo.setUsername(loginVo.getUsername());
        vo.setMenus(menus);
        vo.setValidate(true);
        vo.setToken(token);
        return AjaxResponse.success(vo);
    }
}
