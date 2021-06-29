package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Opjournal;
import com.trkj.thirdproject.entity.Student;
import com.trkj.thirdproject.service.OpjournalService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OpjournalController {
    @Autowired
    private OpjournalService opjournalService;
    @GetMapping("/findopjournal")
    public PageInfo<Opjournal> findopjournal(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        log.debug("开始查询");
        PageHelper.startPage(currentPage,pagesize);
        List<Opjournal> opjournalList=opjournalService.selectByPrimary();
        PageInfo<Opjournal> studentPageInfo=new PageInfo<>(opjournalList);
        log.debug("dd"+opjournalList.toString());
        return studentPageInfo;
    }

}
