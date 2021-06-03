package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.MenuChildrenDao;
import com.trkj.thirdproject.dao.MenuParentDao;
import com.trkj.thirdproject.entity.MenuChildren;
import com.trkj.thirdproject.entity.MenuParent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuChildrenDao menuChildrenDao;
    @Resource
    private MenuParentDao menuParentDao;
    @Override
    public List<MenuChildren> findChildren() {
        return menuChildrenDao.findChildren();
    }

    @Override
    public List<MenuParent> findParent() {
        return menuParentDao.findParent();
    }
}
