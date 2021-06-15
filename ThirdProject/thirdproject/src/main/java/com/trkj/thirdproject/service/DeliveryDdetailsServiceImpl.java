package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookDao;
import com.trkj.thirdproject.dao.DeliveryddetailsDao;
import com.trkj.thirdproject.entity.Deliveryddetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class DeliveryDdetailsServiceImpl implements DeliveryDdetailsService {
    @Resource
    private DeliveryddetailsDao deliveryddetailsDao;
    @Resource
    private BookDao bookDao;

    @Override
    public List<Deliveryddetails> selectAll() {
        return deliveryddetailsDao.selectAll();
    }

    @Override
    public Deliveryddetails insert(Deliveryddetails deliveryddetails) {
        deliveryddetails.setEmpId(1);
        deliveryddetails.setStudentId(1);
        log.debug(deliveryddetails+"");
        deliveryddetailsDao.insert(deliveryddetails);
        return deliveryddetails;
    }

    @Override
    public int deleteByPrimaryKey(int deliveryddetailsId) {
        deliveryddetailsDao.deleteByPrimaryKey(deliveryddetailsId);
        return deliveryddetailsId;
    }
}
