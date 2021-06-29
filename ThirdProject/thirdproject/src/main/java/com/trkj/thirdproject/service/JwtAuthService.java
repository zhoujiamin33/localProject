package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Emp;
import com.trkj.thirdproject.exception.CustomError;
import com.trkj.thirdproject.exception.CustomErrorType;
import com.trkj.thirdproject.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:自定义登录处理类
 * @version 1.0
 */
@Service
@Slf4j
public class JwtAuthService {

    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    UserDetailsService userDetailsService;

    @Resource
    JwtTokenUtil jwtTokenUtil;

    /**
     * 登录认证换取JWT令牌
     *
     * @return JWT
     */
    @CacheEvict(cacheNames = "emp",key = "#empName",beforeInvocation =true )
    public String login(String username, String password) throws CustomError {
        Authentication authentication =null;
        /**
         * Spring Security使用一个Authentication对象来描述当前用户的相关信息。
         * SecurityContextHolder中持有的是当前用户的SecurityContext，
         * 而SecurityContext持有的是代表当前用户相关信息的Authentication的引用。
         * 这个Authentication对象不需要我们自己去创建，在与系统交互的过程中，
         * Spring Security会自动为我们创建相应的Authentication对象，然后赋值给当前的SecurityContext。
         * 但是往往我们需要在程序中获取当前用户的相关信息，比如最常见的是获取当前登录用户的用户名。
         * 在程序的任何地方，通过如下方式我们可以获取到当前用户的用户。
         */
        try {

            UsernamePasswordAuthenticationToken upToken =
                    new UsernamePasswordAuthenticationToken(username, password);
            //该方法将会执行UserDetailsService的loadUserByUsername验证用户名
            //		//以及PasswordEncoder的matches方法验证密码
            log.info("开始登录验证....................");
             authentication = authenticationManager.authenticate(upToken);
            log.info("登录验证完成....................");
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (AuthenticationException e) {
            log.info("++++++++++++++++++" + e.getClass().toString());
            if (e instanceof LockedException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户已被锁定");
            }
            if (e instanceof DisabledException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户已被禁用");
            }

            if (e instanceof CredentialsExpiredException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "密码过期");
            }

            if(e instanceof InternalAuthenticationServiceException){
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "该用户不存在");
            }
            if (e instanceof AccountExpiredException) {
                throw new CustomError(CustomErrorType.ACCOUNT_ERROR
                        , "账户已过期");
            }
            if(e instanceof BadCredentialsException){
                throw new CustomError (CustomErrorType.ACCOUNT_ERROR
                        , "账户异常,"+e.getMessage());
            }
           /* throw new CustomError(CustomErrorType.USER_INPUT_ERROR
                    , e.getMessage());*/
            //e.printStackTrace();
        }
        //获取到当前用户。这个对象通常是UserDetails的实例。
        Emp userDetails = (Emp) authentication.getPrincipal();
        log.debug(userDetails.toString());
        return jwtTokenUtil.generateToken(userDetails.getUsername(),userDetails.getEmpId()+"");
    }


    public String refreshToken(String oldToken) {
        if (!jwtTokenUtil.isTokenExpired(oldToken)) {
            return jwtTokenUtil.refreshToken(oldToken);
        }
        return null;
    }
}



