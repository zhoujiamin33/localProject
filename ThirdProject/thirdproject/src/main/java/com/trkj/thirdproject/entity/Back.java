package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * Back
 * @author 
 */
@Data
public class Back implements Serializable {
    /**
     * 复课编号
     */
    private Integer backId;

    /**
     * 停课编号
     */
    private Suspende suspende;
    private Integer suspendeId;

    /**
     * 学员编号
     */
    private Student student;
    private Integer studentId;

    /**
     * 班级编号
     */
    private Classes classes;
    private Integer classesId;

    /**
     * 课程编号
     */
    private Course course;
    private Integer courseId;

    /**
     * 课程详细编号
     */
    private Detailcourse detailcourse;
    private Integer detailcourseId;

    /**
     * 班级已上课时
     */
    private String classalreadyon;

    /**
     * 缺课节数
     */
    private Integer absent;

    /**
     * 退费状态
     */
    private Integer ispay;

    /**
     * 复课意向
     */
    private Integer intention;

    /**
     * 复课时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date backTime;

    /**
     * 复课办理人
     */
    private String recoursehandler;

    /**
     * 复课审批
     */
    private Integer backApproval;

    /**
     * 复课审批时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date backBapptime;

    /**
     * 撤销复课审批时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date recourseApptime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}