package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * suggest
 * @author 
 */
@Data
public class Suggest implements Serializable {
    /**
     * 意见箱编号
     */
    private Integer suggestId;

    /**
     * 意见箱名称
     */
    private String suggestName;

    /**
     * 部门编号
     */
    private Integer deptId;

    /**
     * 新增人
     */
    private String addname;

    /**
     * 新增时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    private Dept dept;
    private static final long serialVersionUID = 1L;
}