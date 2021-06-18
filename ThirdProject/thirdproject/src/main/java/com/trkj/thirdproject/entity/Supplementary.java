package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Supplementary
 * @author 
 */
@Data
public class Supplementary implements Serializable {
    /**
     * 课程编号
     */
    private Integer supplementaryId;

    /**
     * 课程名称
     */
    private String supplementaryName;

    /**
     * 课程编号
     */
    private Course course;
    private Integer courseId;

    /**
     * 缴费方式
     */
    private Integer payment;


    /**
     * 新增人员
     */
    private String addname;

    /**
     * 新增时间
     */
    private Date addtime;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 最后删除人员
     */
    private String deletename;

    /**
     * 最后删除时间
     */
    private Date deletetime;

    /**
     * 录入人
     */
    private String entryperson;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}