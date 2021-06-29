package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Returnvisit;
import com.trkj.thirdproject.service.ReturnvisitService;
import com.trkj.thirdproject.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ReturnvisitController {
    @Autowired
    private ReturnvisitService returnvisitService;

    @GetMapping("/findAllReturnvisit")
    public List<Returnvisit> findAllReturnvisit(@RequestParam Integer registerId){
       List<Returnvisit> returnvisitList= returnvisitService.selectReturnvisit(registerId);
       return returnvisitList;
    }
    @PostMapping("/AddReturnvisit")
    public Returnvisit inserRreturnvisit(@RequestBody Returnvisit returnvisit){
        log.debug(returnvisit.toString());
        returnvisit=returnvisitService.inserRreturnvisit(returnvisit);
        return returnvisit;
    }

    @PutMapping("/DelRet")
    public int delstuRetTime(@RequestParam("returnvisitId") List<Integer>returnvisitId){
        log.debug("启用批量删除");
        return returnvisitService.delstuRetTime(returnvisitId);
    }

    @GetMapping("/Numberofreturnvisits")
    public AjaxResponse Numberofreturnvisits(){
        return AjaxResponse.success(returnvisitService.Numberofreturnvisits());
    }
}
