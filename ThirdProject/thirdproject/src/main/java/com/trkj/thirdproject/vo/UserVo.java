package com.trkj.thirdproject.vo;

import com.trkj.thirdproject.entity.SysMenu;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private int pon;
    private int id;
    private String username;
    private String password;
    private String token;
    private boolean isValidate;
    private List<SysMenu> menus;
}
