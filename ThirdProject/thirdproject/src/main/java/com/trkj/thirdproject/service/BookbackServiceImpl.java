package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookbackDao;
import com.trkj.thirdproject.entity.Bookback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookbackServiceImpl implements BookbackService {
    @Resource
    private BookbackDao bookbackDao;

    @Override
    public List<Bookback> selectAll() {
        return bookbackDao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(int bookbackId) {
        bookbackDao.deleteByPrimaryKey(bookbackId);
        return bookbackId;
    }

    @Override
    public Bookback insert(Bookback bookback) {
        bookback.setEmpId(1);
        bookback.setStoragetime(new Date());
        bookbackDao.insert(bookback);
        return bookback;
    }

    @Override
    public List<Bookback> selectBookBack(String value, String input) {
        return bookbackDao.selectBookBack(value, input);
    }

    @Override
    public Bookback updateByPrimaryKey(Bookback bookback) {
        bookbackDao.updateByPrimaryKey(bookback);
        return bookback;
    }
}
