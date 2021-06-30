package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SysMenuDao;
import com.trkj.thirdproject.entity.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysmenuServiceImpl implements SysmenuService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Override
    public List<SysMenu> selectAllmenu() {
        return sysMenuDao.selectAllmenu();
    }

    @Override
    public SysMenu insertSelective(SysMenu record) {
        sysMenuDao.insertSelective(record);
        return record;
    }
}
