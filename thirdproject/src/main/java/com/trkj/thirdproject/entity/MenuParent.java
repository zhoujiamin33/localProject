package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * menu_parent
 * @author 
 */
@Data
public class MenuParent implements Serializable {
    /**
     * 菜单编号
     */
    private Integer parentId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuPath;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 新增人
     */
    private String addname;

    /**
     * 新增时间
     */
    private Date addtime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}