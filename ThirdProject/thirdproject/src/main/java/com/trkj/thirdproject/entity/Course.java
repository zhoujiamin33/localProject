package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * course
 * @author 
 */
@Data
//@ToString(exclude = "Classtype")
public class Course implements Serializable {
    /**
     * 课程编号
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程状态
     */
    private Integer courseState;

    /**
     * 新增时间
     */
    private Integer classhours;

    /**
     * 课程费用
     */
    private BigDecimal courseMoney;

    /**
     * 课类编号
     */
    private Integer classtypeId;

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
    public String updatename;

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

    private Classtype classtype;

    private static final long serialVersionUID = 1L;

}