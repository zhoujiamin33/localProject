package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * sys_menu
 * @author 
 */
@Data
public class SysMenu implements Serializable {
    private Integer id;

    /**
     * 父菜单ID
     */
    private Integer menuPid;

    /**
     * 当前菜单所有父菜单
     */
    private String menuPids;

    /**
     * 0:不是叶子节点，1:是叶子节点
     */
    private Byte isLeaf;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 允许客户端提交的方法get查询/post添加/put修改/delete删除
     */
    private String method;

    /**
     * 跳转URL
     */
    private String url;

    /**
     * 组件名称
     */
    private String componentName;

    /**
     * 组件地址
     */
    private String componentPath;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 菜单层级
     */
    private Byte level;

    /**
     * 0:启用,1:禁用
     */
    private Byte status;

    private static final long serialVersionUID = 1L;

    /** 侧边栏子菜单 */
    private List<SysMenu> asideChildren = new ArrayList<SysMenu>();

    public void setAsideChildren(List<SysMenu> asideChildren) {
        this.asideChildren = asideChildren;
    }
}