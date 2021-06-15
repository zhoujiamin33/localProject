package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Memorandumattachment;
import com.trkj.thirdproject.service.MemorandumattachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MemorandumattachmentController {
    @Autowired
    private MemorandumattachmentService memorandumattachmentService;
    @GetMapping("/findAllMemorandumattachment")
    public List<Memorandumattachment> findAllMemorandumattachment(){
        return memorandumattachmentService.selectMemorandumAttachment();
    }
}
