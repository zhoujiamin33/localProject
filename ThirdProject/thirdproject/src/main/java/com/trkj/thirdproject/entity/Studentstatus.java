package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * studentstatus
 * @author 
 */
@Data
public class Studentstatus implements Serializable {
    /**
     * 学员状态编号
     */
    private Integer studentstatusId;

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
     * 停课编号
     */
    private Integer suspendeId;

    /**
     * 报班时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date signuptime;

    /**
     * 学员状态
     */
    private Integer status;

    /**
     * 删除人员
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