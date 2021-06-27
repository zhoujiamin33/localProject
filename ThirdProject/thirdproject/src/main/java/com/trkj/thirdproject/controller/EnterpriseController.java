package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Enterprise;
import com.trkj.thirdproject.service.EnterpriseService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @PutMapping("/enterprise")
    @LogginAnnotation(message = "修改公司档案")
    public Enterprise updeenterprise(@RequestBody Enterprise enterprise){
        enterprise=enterpriseService.updateEnterprise(enterprise);
        return enterprise;
    }
    @GetMapping("/findenterprise")
    public AjaxResponse findenterprise() {
        Enterprise enterprise=enterpriseService.seleallenterprise();

        return AjaxResponse.success(enterprise);
    }


}
