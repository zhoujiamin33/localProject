package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * detailcourse
 * @author 
 */
@Data
public class Detailcourse implements Serializable {
    /**
     * 课程详细编号
     */
    private Integer detailcourseId;

    /**
     * 课程编号
     */
    private Integer courseId;

    /**
     * 课程详细名称
     */
    private String detailcourseName;

    /**
     * 课程序列号
     */
    private Integer serial;

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

    private  Course course;
    //详细课程条数
    private Integer totalcount;

    private static final long serialVersionUID = 1L;
}