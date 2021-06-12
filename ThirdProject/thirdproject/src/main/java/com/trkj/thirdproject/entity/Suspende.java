package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * suspende
 * @author 
 */
@Data
public class Suspende implements Serializable {
    /**
     * 停课编号
     */
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
     * 已上课时
     */
    private String alreadyon;

    /**
     * 停课时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date suspendeTime;

    /**
     * 停课理由
     */
    private String suspendeReason;

    /**
     * 停课办理人
     */
    private String suspendeHandler;

    /**
     * 停课审批人
     */
    private String suspendeSappname;

    /**
     * 停课审批
     */
    private Integer suspendeApproval;

    /**
     * 停课审批时间
     */
    private Date suspendeSapptime;

    /**
     * 撤销停课审批人
     */
    private String revokeAppname;

    /**
     * 撤销停课审批时间
     */
    private Date revokeApptime;

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