package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * emp
 * @author
 */
@Data
public class Emp implements UserDetails {
    /**
     * 编号
     */
    private Bookstorage bookstorage;
    private Integer empId;

    /**
     * 职位编号
     */
    private Integer positionId;

    /**
     * 部门编号
     */
    private Integer deptId;
    /**
     * 职位编号
     */
    private Position positionList;

    /**
     * 部门编号
     */
    private Dept deptList;

    /**
     * 企业档案编号
     */
    private Integer enterpriseId;

    /**
     * 工号
     */
    private String jobnumber;

    /**
     * 职工名称
     */
    private String empName;

    /**
     * 职工性别
     */
    private String empSex;

    /**
     * 职工电话
     */
    private String empPhone;

    /**
     * 电子邮件
     */
    private String eMail;

    /**
     * 生日
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date birthday;

    /**
     * 个人信息照片
     */
    private String personalinformationphoto;

    /**
     * 照片
     */
    private String photo;

    /**
     * 教育水平
     */
    private String education;

    /**
     * 毕业学校
     */
    private String graduate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 职工状态
     */
    private Integer workersstate;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date addtime;

    /**
     * 最后修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 离职办理人
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private String leavename;

    /**
     * 离职办理时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date leavetime;

    /**
     * 职员状态
     */

    private Integer empstate;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 限制登录状态
     */
    private Integer loginstate;

    /**
     * 0无效用户，1是有效用户
     */
    private Boolean enabled;

    /**
     * 账户是否没过期
     */
    private Boolean accountNonExpired;

    /**
     * 是否没被锁定
     */
    private Boolean accountNonLocked;

    /**
     * 密码是否没有过期
     */
    private Boolean credentialsNonExpired;

    Collection<? extends GrantedAuthority> authorities;  //用户的权限集合


    private static final long serialVersionUID = 1L;

    @Override
    public String getUsername() {
        return empName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}