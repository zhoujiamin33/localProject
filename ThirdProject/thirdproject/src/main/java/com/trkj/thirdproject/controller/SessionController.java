package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Session;

import com.trkj.thirdproject.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SessionController {
    @Autowired
    private SessionService sessionService;
    @GetMapping("/findSessions")
    public List<Session>findAIISessions(){
        log.debug("Controller 方法调用");
        return sessionService.selectAIISessions();
    }
    @PostMapping("/Session")
    public Session addSession(@RequestBody Session session){
        log.debug(session.getAddname()+"--------");
        session=sessionService.addSession(session);
        return session;
    }
    @PutMapping("/Session")
    public Session updateSession(@RequestBody Session session){
        log.debug("开始修改");
        log.debug(session.toString());
        session=sessionService.updateSession(session);
        return session;
    }
    //分页
    @GetMapping("/findPageSession")
    public PageInfo<Session> findPageFaq(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Session> entityPage=sessionService.selectAIISessions();
        PageInfo<Session> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }
}
