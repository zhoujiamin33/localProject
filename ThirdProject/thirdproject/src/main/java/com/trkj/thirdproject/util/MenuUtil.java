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

               // log.debug(o.toString()+"ssssssssssssssssssssssss");
            List<SysMenu> two=new ArrayList<>();
            for (SysMenu s:menus){
                log.debug(s.toString());
                if(o.getId().equals(s.getMenuPid())){
                    log.debug(s.toString()+"ssssssss");
                    two.add(s);
                }
            }
            //log.debug(two.toString());
            o.setAsideChildren(two);
            log.debug(o.getAsideChildren().toString()+"+++++++++++++++++++++++++++");
        });
        return one;
    }
}
