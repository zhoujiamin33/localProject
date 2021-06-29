package com.trkj.thirdproject.config;


import com.trkj.thirdproject.filter.JwtAuthenticationTokenFilter;
import com.trkj.thirdproject.handle.UserAuthAccessDeniedHandler;
import com.trkj.thirdproject.handle.UserAuthenticationEntryPointHandler;
import com.trkj.thirdproject.handle.UserLogoutSuccessHandler;
import com.trkj.thirdproject.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

//@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    MyUserDetailsService myUserDetailsService;
    /**
     * 用户注销处理类
     */
    @Resource
    private UserLogoutSuccessHandler myLogoutSuccessHandler;
    /**
     * 用户未登录处理类
     */
    @Resource
    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;
    /**
     * 已登录用户无权限处理类
     */
    @Resource
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用CSRF保护,指跨站请求伪造，我们使用JWT机制基本可以预防
        http.csrf().disable()
                .cors()
                .and()
//                .formLogin().loginPage("/Login.jsp")
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                .addFilterBefore(corsFilter, LogoutFilter.class)
                //提供注销支持。
                .logout()
                //触发注销的URL（默认值为 /logout ）。 如果启用CSRF保护（默认），则该请求也必须是POST。
                .logoutUrl("/signout")
                //添加一个 LogoutHandler用于处理用户注销时的处理。
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .and()
                //http.authorizeRequests()方法有很多子方法，每个子匹配器将会按照声明的顺序起作用,即可以在这里定制请求授权的规则
                .authorizeRequests()
                //如果URL等于"/login"此时任何用户可以访问，如果是"/login/**",
                // 则表示URL等于/login或是以/login开头的，任何用户都可以访问请求。
                //这里这样配置的目的是在于我们自己定义登录验证的地址，而没有用spring security默认的验证地址
                .antMatchers("/login","/captchaImage").anonymous()
                .antMatchers("/find**").anonymous()
                .antMatchers("/Find**").anonymous()
                .antMatchers("/select**").anonymous()
                .antMatchers("/common/download**").anonymous()
                .antMatchers("/common/download/resource**").anonymous()
                .antMatchers("/swagger-ui/**").anonymous()
                .antMatchers("/swagger-resources/**").anonymous()
                .antMatchers("/druid/**").anonymous()
                //"/SysMain/**","/DeptMain/**这两个路径下的资源需要有admin角色或是有权限
                .antMatchers("/SysMains/**","/DeptMain/**").access("@rabcService.hasRole(request,authentication,'admin') or @rabcService.hasPermission(request,authentication)")
                //MyRBACService
                //.antMatchers("/SysMain/**","/DeptMain/**").hasRole("admin")

                //其它URL都需要用户通过rabcService.hasPermission方法的验证才可以访问
                .anyRequest().access("@rabcService.hasPermission(request,authentication)")
                // .and()
                .and()
                //定制我们自己的 session 策略
                .sessionManagement()
                // 调整为让 Spring Security 不创建和使用 session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 配置没有权限自定义处理类
                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                //配置用户未登录处理类
                .authenticationEntryPoint(userAuthenticationEntryPointHandler);

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //AuthenticationManagerBuilder用于创建AuthenticationManager。
        //允许轻松构建内存身份验证，LDAP身份验证，基于JDBC的身份验证，
        // 添加UserDetailsService以及添加AuthenticationProvider。
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 使用BCryptPasswordEncoder，表示存储中（数据库）取出的密码必须是经过BCrypt加密算
     * 法加密的。这里需要注意的是，因为我们使用了BCryptPasswordEncoder加密解密，
     * 所以数据库表里面存的密码应该是加密之后的密码（造数据的过程）
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    /**
     * AuthenticationManager认证管理接口类，其定义了认证方法authenticate()。
     * @return
     * @throws Exception
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
