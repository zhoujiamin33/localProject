package com.trkj.thirdproject.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:菜单或按钮（权限）判断业务实现类
 * @version 1.0
 */
@Component("rabcService")//重点之一
@Slf4j
public class MyRBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private MyUserDetailsService sysUserService;

    /**
     * 判断某用户是否具有该资源的访问权限
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        log.debug("开始验证权限");
        if(principal instanceof UserDetails){
            UserDetails userDetails = ((UserDetails)principal);

            //"/syslog"
            //本次要访问的资源
            String auth=request.getRequestURI().substring(14);
            SimpleGrantedAuthority simpleGrantedAuthority
                    = new SimpleGrantedAuthority(auth);
            log.debug(simpleGrantedAuthority.toString());

            log.debug(auth);
            log.debug(userDetails.getAuthorities().toString());
            return userDetails.getAuthorities().contains(simpleGrantedAuthority);
        }

        return false;
    }
    /**
     * 判断某用户是否具有某个角色
     */
    public boolean hasRole(HttpServletRequest request, Authentication authentication, String ...roleName){
        Object principal = authentication.getPrincipal();
        log.debug("开始验证角色");
        if(principal instanceof UserDetails){
            UserDetails userDetails = ((UserDetails)principal);
            for(String n : roleName){

                SimpleGrantedAuthority simpleGrantedAuthority
                        = new SimpleGrantedAuthority("ROLE_"+n);
                log.debug("角色:"+n,simpleGrantedAuthority);
                boolean flag= userDetails.getAuthorities().contains(simpleGrantedAuthority);
                if(flag) return flag;
            }
        }
        return false;
    }

    private boolean matchers(String url, HttpServletRequest request) {
        log.info("在matchers方法中："+url);
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }

}
