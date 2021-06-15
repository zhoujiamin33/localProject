package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.DropoutDao;
import com.trkj.thirdproject.entity.Dropout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DropoutServiceImpl implements DropoutService {
    @Autowired
    private DropoutDao dropoutDao;
    @Override
    public Dropout insertSelective(Dropout record) {
        dropoutDao.insertSelective(record);
        return record;
    }
//查询所有
    @Override
    public List<Dropout> selectAlldropout() {
        return dropoutDao.selectAlldropout();
    }
    //    模糊查询
    @Override
    public List<Dropout> findclaNmae_stuNameAndxuehao(String index, String value) {
        List<Dropout> dropoutList=dropoutDao.findclaNmae_stuNameAndxuehao(index, value);
        return dropoutList;
    }
    //点击审核状态为已审核或者删除按钮时效性为1
    @Override
    public Dropout updateByPrimaryKeySelective(Dropout record) {
       dropoutDao.updateByPrimaryKeySelective(record);
        return record;
    }
    //根据退学编号查询
    @Override
    public Dropout selectByPrimaryKey(Integer dropId) {
        Dropout dropout=dropoutDao.selectByPrimaryKey(dropId);
        return dropout;
    }
}
