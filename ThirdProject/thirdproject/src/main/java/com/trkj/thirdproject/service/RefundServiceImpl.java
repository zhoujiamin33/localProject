package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassesDao;
import com.trkj.thirdproject.dao.DetailcourseDao;
import com.trkj.thirdproject.dao.RefundDao;
import com.trkj.thirdproject.entity.Classes;
import com.trkj.thirdproject.entity.Detailcourse;
import com.trkj.thirdproject.entity.Refund;
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
    @Override
    public Refund insertRefund(Refund refund) {
        //得到课程详细id
        Detailcourse detailcourse=classesdao.selectDetailCourse(refund.getClassesId());
        Integer detailcourseId=detailcourse.getDetailcourseId();
        refund.setDetailcourseId(detailcourseId);
        //退费类型
        refund.setRefundtype("退学退费");
        //新增时间
        refund.setAddtime(new Date());
        //查询剩余的课程,并计算退费金额
        Classes classes=classesdao.selectById(refund.getClassesId());
        int yishang=classes.getWhendetails();
        int totalHours=classes.getCourse().getClasshours();
        BigDecimal Hoursmoney=classes.getCourse().getCourseMoney();
        BigDecimal allsprice= Hoursmoney.multiply(new BigDecimal(totalHours-yishang));
        refund.setDropMoney(allsprice);
        return refunddao.insertRefund(refund);
    }

    @Override
    public List<Refund> selectAllRefund() {
        return refunddao.selectAllRefund();
    }
}