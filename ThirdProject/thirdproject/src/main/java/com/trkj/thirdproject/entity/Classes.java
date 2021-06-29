package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * classes
 * @author 
 */
@Data
public class Classes implements Serializable {
    /**
     * 班级编号
     */
    private Integer classesId;

    /**
     * 班级名称
     */
    private String classesName;
    /**
     * 班级号
     */
    private String classesNumber;
    /* *
     *   已上课程
     */
    private Integer whendetails;

    /**
     * 开班状态
     */
    private Integer classesOpen;

    /**
     * 课程编号
     */
    private  Course course;
    private Integer courseId;

    /**
     * 教室编号
     */
    private Classroom classroom;
    private Integer classroomId;

    /**
     * 教员编号
     */
    private Integer teacherId;

    /**
     * 班主任编号
     */
    private Emp emp;
    private Integer empId;

    /**
     * 课程详细编号
     */
    private Detailcourse detailcourse;
    private Integer detailcourseId;

    /**
     * 培训开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date starteddate;

    /**
     * 培训计划结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date enddate;

    /**
     * 培训最终结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lastdate;

    /**
     * 新增人员
     */
    public String addname;

    /**
     * 新增时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date addtime;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date updatetime;

    /**
     * 最后删除人员
     */

    private String deletename;

    /**
     * 最后删除时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;
    /**
     * 教材编号
     */
    private Book book;
    private Integer userbookId;

    //学生数量
    private Integer counttotal;

    private static final long serialVersionUID = 1L;
}