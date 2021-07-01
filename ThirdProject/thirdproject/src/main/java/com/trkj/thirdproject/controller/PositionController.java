package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.aspect.aop.LogginAnnotation;
import com.trkj.thirdproject.entity.Position;
import com.trkj.thirdproject.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PositionController {
    @Autowired
    private PositionService positionService;
    @GetMapping("/findallposition")
    public List<Position> findallposition(){
        return positionService.selectAllposition();
    }
    @PostMapping("/addposition")
    @LogginAnnotation(message = "新增职位")
    public Position addposition(@RequestBody Position position){
        position=positionService.addposition(position);
        return position;
    }
    @PutMapping("/updateposition")
    @LogginAnnotation(message = "修改职位")
    public Position updateposition(@RequestBody Position position){
        position=positionService.updateposition(position);
        return position;
    }
//    @DeleteMapping("/position/{positionId}")
//    public void delposition(@PathVariable("positionId") Integer positionId){
//        positionService.deleteposition(positionId);
//    }
    @GetMapping("/findpositionname")
    public PageInfo<Position> findpositionname(@RequestParam("positionName") String positionName, @RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Position> entityPage=positionService.selectByname(positionName);
        PageInfo<Position> positionPageInfo=new PageInfo<>(entityPage);
        return positionPageInfo;
    }
    //删除后为已过期
    @PutMapping("/delTimeLiness")
    @LogginAnnotation(message = "删除职位")
    public int delTimeLiness(@RequestParam("deletename")String deletename,@RequestParam("positionId") Integer positionId){
        return positionService.delTimeLiness(deletename,positionId);
    }
    //    <!--  删除之后显示未过期的职位  //分页-->
  @GetMapping("/selTimeLiness")
    public PageInfo<Position> selTimeLiness(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize){
      PageHelper.startPage(currentPage,pagesize);
      List<Position> entityPage=positionService.selectTimeLiness();
      PageInfo<Position> positionPageInfo=new PageInfo<>(entityPage);
      return positionPageInfo;


  }


}
