package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.*;
import com.trkj.thirdproject.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RefundServiceImpl implements RefundService {
    @Resource
    private RefundDao refunddao;
    @Resource
    private ClassesDao classesdao;
    @Resource
    private DetailcourseDao detailcoursedao;
    @Resource
    private SuspendeDao suspendedao;
    @Resource
    private DropoutDao dropoutDao;
    @Override
    public Refund insertRefund(Refund refund) {
//        根据退学编号查询
        Dropout dropout=dropoutDao.selectByPrimaryKey(refund.getDropId());
        //得到课程详细id
        Detailcourse detailcourse=classesdao.selectDetailCourse(dropout.getClassesId());
        int detailcourseId=detailcourse.getDetailcourseId();
        log.debug(detailcourseId+"id");
        refund.setDetailcourseId(detailcourseId);
        //新增时间
        refund.setAddtime(new Date());
        //退费类型
        if(refund.getBackId()==null){
            refund.setRefundtype("退学退费");
            //查询剩余的课程,并计算退费金额
            Classes classes=classesdao.selectById(dropout.getClassesId());
            int yishang=classes.getWhendetails();
            int totalHours=classes.getCourse().getClasshours();
            BigDecimal Hoursmoney=classes.getCourse().getCourseMoney();
            BigDecimal allsprice= Hoursmoney.multiply(new BigDecimal(totalHours-yishang));
            log.debug(yishang+"已上");
            log.debug(totalHours+"总课时");
            refund.setDropMoney(allsprice);
            log.debug(allsprice+"allsprice");
            log.debug("新增退费完成"+"-----------------------------------------");
        }else {
            refund.setRefundtype("停课退费");
            Suspende suspende=suspendedao.selectByPrimaryKey(refund.getSuspendeId());
            log.debug(suspende.getClasses().getWhendetails()+"xzdsdawddsa");
            int yishang=suspende.getClasses().getWhendetails();
            Classes classes=classesdao.selectById(dropout.getClassesId());
            int total=classes.getCourse().getClasshours();
            BigDecimal Hoursmoney=classes.getCourse().getCourseMoney();
            BigDecimal refundmoney=Hoursmoney.multiply(new BigDecimal(total-yishang));
            refund.setDropMoney(refundmoney);
            refund.setStudentId(dropout.getStudentId());
            log.debug(refundmoney+" ");
            log.debug("停课退费已完成---------------------------");
        }
        refunddao.insertRefund(refund);
        return refund;
    }

    @Override
    public List<Refund> selectAllRefund() {
        return refunddao.selectAllRefund();
    }

    @Override
    public Refund updateapproval(Refund refund) {
        refund.setCwAppname("admin");
        refund.setCwApptime(new Date());
        refunddao.updateapproval(refund);
        return refund;
    }

    @Override
    public Refund updateRevokeapproval(Refund refund) {
        refund.setCwDropappname("admin");
        refund.setCwDropapptime(new Date());
        refunddao.updateRevokeapproval(refund);
        return refund;
    }

    @Override
    public Refund deleterefund(Refund refund) {
        refund.setDeletename("admin");
        refund.setDeletetime(new Date());
        refunddao.deleterefund(refund);
        return refund;
    }

    @Override
    public List<Refund> selectByContion(String startTime, String endTime) {
        return refunddao.selectByContion(startTime, endTime);
    }
}
