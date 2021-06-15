package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookdeliveryDao;
import com.trkj.thirdproject.entity.Bookdelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class BookdeliveryServiceImpl implements BookdeliveryService {
    @Resource
    private BookdeliveryDao bookdeliveryDao;

    @Override
    public int deleteByPrimaryKey(int bookdeliveryId) {
        bookdeliveryDao.deleteByPrimaryKey(bookdeliveryId);
        return bookdeliveryId;
    }

    @Override
    public Bookdelivery insert(Bookdelivery bookdelivery) {
        bookdelivery.setEmpId(1);
        bookdelivery.setStudentId(1);
        log.debug(bookdelivery+"");
        bookdeliveryDao.insert(bookdelivery);
        return bookdelivery;
    }
}
