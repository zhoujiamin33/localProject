package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.MenuChildren;
import com.trkj.thirdproject.entity.MenuParent;

import java.util.List;

public interface MenuService {
    //    查询
    List<MenuChildren> findChildren();
    //查询
    List<MenuParent> findParent();
}
