package com.trkj.thirdproject.handle;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trkj.thirdproject.util.ServletUtil;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:自定义用户注销处理类，LogoutSuccessHandler有默认实现，但无法返回JSON数据
 * @version 1.0
 */
@Component
@Slf4j
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws JsonProcessingException {
        log.info("退出系统！！！");
        response.setContentType("application/json;charset=utf-8");
        AjaxResponse ajaxResponse= AjaxResponse.success("已退出");
        SecurityContextHolder.clearContext();
        ObjectMapper om=new ObjectMapper();
        ServletUtil.responseJson(response, om.writeValueAsString(ajaxResponse));

    }
}