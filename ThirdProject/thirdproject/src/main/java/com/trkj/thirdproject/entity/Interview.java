package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Interview
 * @author 
 */
@Data
public class Interview implements Serializable {
    /**
     * 访谈编号
     */
    private Integer detailsId;

    /**
     * 班级编号
     */
    private Classes classes;
    private Integer classesId;

    /**
     * 被访谈学员
     */
    private Student student;
    private Integer studentId;

    /**
     * 访谈人
     */
    private Emp emp;
    private Integer empId;

    /**
     * 访谈主题
     */
    private String theme;

    /**
     * 访谈内容
     */
    private String interviewcontent;

    /**
     * 访谈时间
     */
    private Date interviewtime;

    /**
     * 进展程度
     */
    private String progress;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人员
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