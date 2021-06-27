package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.PositionDao;
import com.trkj.thirdproject.dao.SysMenuDao;
import com.trkj.thirdproject.entity.SysMenu;
import com.trkj.thirdproject.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private SysMenuDao menuDao;
    @Override
    public List<SysMenu> getMenuByUname(String userName) {
        List<SysMenu> sysMenus= menuDao.findMenusByPositionNames(getRoleCodesByUname(userName));
        return MenuUtil.assemberMenus(sysMenus);
    }
    private List<String> getRoleCodesByUname(String userName){
        return positionDao.findPositionByEmpName(userName);
    }
}
