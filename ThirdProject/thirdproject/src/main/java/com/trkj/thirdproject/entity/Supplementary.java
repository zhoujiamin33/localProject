package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date addtime;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date updatetime;

    /**
     * 最后删除人员
     */
    private String deletename;

    /**
     * 最后删除时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date deletetime;

    /**
     * 录入人
     */
    private String entryperson;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 审核状态
     */
    private Integer state;

    /**
     * 学员表id
     */
    private Student student;
    private Integer studentId;

    private static final long serialVersionUID = 1L;
}