package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.SysMenu;

import java.util.List;

public interface PermissionService {
    public List<SysMenu> getMenuByUname(String userName);
}
