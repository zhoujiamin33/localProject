package com.trkj.thirdproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.thirdproject.entity.Memorandumattachment;
import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.service.MemorandumattachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class MemorandumattachmentController {
    @Autowired
    private MemorandumattachmentService memorandumattachmentService;
    //学员交接招生显示
    @GetMapping("/findAllMemorandumattachment"  )
    public List<Memorandumattachment> findAllMemorandumattachment(){
        return memorandumattachmentService.selectMemorandumAttachment();
    }
    //分页
    @GetMapping("/findPageMemorandumattachment")
    public PageInfo<Memorandumattachment> selectAIIMem(@RequestParam("currentPage") int currentPage,@RequestParam("pagesize") int pagesize){
        PageHelper.startPage(currentPage,pagesize);
        List<Memorandumattachment> entityPage=memorandumattachmentService.selectAIIMem();
        PageInfo<Memorandumattachment> classtypePageInfo=new PageInfo<>(entityPage);
        return classtypePageInfo;
    }

    //学员交接模糊查询
    @GetMapping("/selectMemlivery")
    public PageInfo<Memorandumattachment> selectMemlivery(@RequestParam("currentPage") int currentPage, @RequestParam("pagesize") int pagesize, @RequestParam("value") String value, @RequestParam("input") String input){
        PageHelper.startPage(currentPage,pagesize);
        List<Memorandumattachment> entityPage=memorandumattachmentService.selectMemlivery(value, input);
        PageInfo<Memorandumattachment> memorandumattachmentPageInfo=new PageInfo<>(entityPage);
        return memorandumattachmentPageInfo;
    }
 //    @DeleteMapping("/delAuthorByroleid")
//    public AjaxResponse delAuthorByroleid(@RequestParam("roleid") int roleid,@RequestParam("Authors")String SAuthors) {
//        sysRoleMenuDao.deleteByPrimaryKey(roleid);
//        // log.debug(SAuthors+"---------------");
//        String [] strs=SAuthors.split("&");
//        List<Integer> Authors=new ArrayList<>();
//        for(int i=0,len=strs.length;i<len;i++){
//            String[] a=strs[i].split("=");
//            //log.debug(a[1]);
//            Authors.add(Integer.valueOf(a[1]));
//        }
    @DeleteMapping("/Spzszt")
    public int PiliangZssp(@RequestParam("memorandumattachmentId") List<Integer> memorandumattachmentId){
        log.debug("学员交接进行招生审批");
        log.debug(memorandumattachmentId.toString()+"-------------=====");
        Date jwexaminetime=new Date();
        return memorandumattachmentService.PiliangZssp(memorandumattachmentId,jwexaminetime);
    }
}
