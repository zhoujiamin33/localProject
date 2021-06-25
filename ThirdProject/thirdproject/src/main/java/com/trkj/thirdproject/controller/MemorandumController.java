package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Memorandum;
import com.trkj.thirdproject.entity.Trainingperiod;
import com.trkj.thirdproject.service.MemorandumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class MemorandumController {
    @Autowired
    private MemorandumService memorandumService;

    @PostMapping("/addMemorandum")
    @LogginAnnotation(message = "新增备忘录内容")
    public Memorandum insert(@RequestBody Memorandum memorandum){
        memorandumService.insert(memorandum);
        return memorandum;
    }

    @GetMapping("/findMemorandum")
    private List<Memorandum> selectAllMemorandum(){
        log.debug("Controller方法调用");
        return memorandumService.selectAllMemorandum();
    }
}
