package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.SysMenu;

import java.util.List;

public interface SysmenuService {
    List<SysMenu> selectAllmenu();
    SysMenu insertSelective(SysMenu record);
}
