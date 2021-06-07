package com.trkj.thirdproject.entity;

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
    private Integer empId;

    /**
     * 课程详细编号
     */
    private Integer detailcourseId;

    /**
     * 培训开始时间
     */
    private Date starteddate;

    /**
     * 培训计划结束日期
     */
    private Date enddate;

    /**
     * 培训最终结束日期
     */
    private Date lastdate;

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