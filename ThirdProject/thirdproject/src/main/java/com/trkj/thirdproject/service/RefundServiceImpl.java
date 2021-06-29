package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassesDao;
import com.trkj.thirdproject.dao.DetailcourseDao;
import com.trkj.thirdproject.dao.RefundDao;
import com.trkj.thirdproject.dao.SuspendeDao;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
import com.trkj.thirdproject.entity.Refund;
import com.trkj.thirdproject.entity.Suspende;
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
    @Override
    public Refund insertRefund(Refund refund) {
        //得到课程详细id
        Detailcourse detailcourse=classesdao.selectDetailCourse(refund.getClassesId());
        int detailcourseId=detailcourse.getDetailcourseId();
        log.debug(detailcourseId+"id");
        refund.setDetailcourseId(detailcourseId);
        //新增时间
        refund.setAddtime(new Date());
        //退费类型
        if(refund.getBackId()==null){
            refund.setRefundtype("退学退费");
            //查询剩余的课程,并计算退费金额
            Classes classes=classesdao.selectById(refund.getClassesId());
            int yishang=classes.getWhendetails();
            int totalHours=classes.getCourse().getClasshours();
            BigDecimal Hoursmoney=classes.getCourse().getCourseMoney();
            BigDecimal allsprice= Hoursmoney.multiply(new BigDecimal(totalHours-yishang));
            refund.setDropMoney(allsprice);
            log.debug(allsprice+"allsprice");
            log.debug("新增退费完成"+"-----------------------------------------");
        }else {
            refund.setRefundtype("停课退费");
            Suspende suspende=suspendedao.selectByPrimaryKey(refund.getSuspendeId());
            int yishang=suspende.getClasses().getWhendetails();
            Classes classes=classesdao.selectById(refund.getClassesId());
            int total=classes.getCourse().getClasshours();
            BigDecimal Hoursmoney=classes.getCourse().getCourseMoney();
            BigDecimal refundmoney=Hoursmoney.multiply(new BigDecimal(total-yishang));
            refund.setDropMoney(refundmoney);
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
    public List<Refund> selectByContion(int Approval, String value1, String value2, String input) {
        return refunddao.selectByContion(Approval, value1, value2, input);
    }
}
