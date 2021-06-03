package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * semester
 * @author 
 */
@Data
public class Semester implements Serializable {
    /**
     * 学期编号
     */
    private Integer semesterId;

    /**
     * 学期名称
     */
    private String semesterName;

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
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}