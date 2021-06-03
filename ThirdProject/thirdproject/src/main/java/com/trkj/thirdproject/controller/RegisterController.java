package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Register;

import com.trkj.thirdproject.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j

public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @GetMapping("/findAllRegister")
    public List<Register> findAllRegister(){
        return registerService.selectRegister();
    }
}
