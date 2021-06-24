package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Opjournal;
import com.trkj.thirdproject.service.OpjournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OpjournalController {
    @Autowired
    private OpjournalService opjournalService;
    @GetMapping("/findopjournal")
    public List<Opjournal> findopjournal(){
        List<Opjournal> opjournalList=opjournalService.selectByPrimary();
        log.debug("dd"+opjournalList.toString());
        return opjournalList;
    }
}
