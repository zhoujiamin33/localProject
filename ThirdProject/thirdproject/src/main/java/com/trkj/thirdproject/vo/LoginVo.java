package com.trkj.thirdproject.vo;

import lombok.Data;

/**
 * 用户登录对象
 *
 */
@Data
public class LoginVo {

    private int id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid = "";


}
