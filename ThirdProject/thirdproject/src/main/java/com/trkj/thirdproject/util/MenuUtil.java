package com.trkj.thirdproject.util;

import com.trkj.thirdproject.entity.SysMenu;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MenuUtil {
    public static List<SysMenu> assemberMenus(List<SysMenu> menus){
        log.debug(menus.toString());
        List<SysMenu> one=menus.stream().filter(u -> u.getMenuPid()==0).collect(Collectors.toList());
        log.debug(one.toString());
        one.forEach(o->{
            log.debug(o.getComponentName());
            List<SysMenu> two=menus.stream().filter(u -> u.getMenuPid().equals(o.getId())).collect(Collectors.toList());
            o.setAsideChildren(two);
//            log.debug(o.toString());
//            log.debug(two.toString());
        });
        return one;
    }
}
