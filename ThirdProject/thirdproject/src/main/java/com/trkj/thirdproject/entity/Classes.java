package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
    private Integer detailcourseId;

    /**
     * 培训开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date starteddate;

    /**
     * 培训计划结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

    /**
     * 培训最终结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date lastdate;

    /**
     * 新增人员
     */
    private String addname;

    /**
     * 新增时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    /**
     * 最后删除人员
     */

    private String deletename;

    /**
     * 最后删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    private static final long serialVersionUID = 1L;
}