package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * register
 * @author 
 */
@Data
public class Register implements Serializable {
    /**
     * 咨询登记编号
     */
    private Integer registerId;

    /**
     * 咨询人
     */
    private String consultant;

    /**
     * 咨询人性别
     */
    private String sex;

    /**
     * 生源渠道编号
     */
    private Integer sourceId;

    /**
     * 计划首次回访日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planreturnvisit;

    /**
     * 咨询方式
     */
    private String consultationmode;

    /**
     * 咨询状态
     */
    private Integer attentstate;

    /**
     * 缴费状态
     */
    private Integer paystate;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 新增咨询登记职工
     */
    private String addname;

    /**
     * 新增咨询登记当前时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

    /**
     * 咨询内容
     */
    private String consultcontent;

    /**
     * 最后修改人员
     */
    private String lastupdatename;

    /**
     * 最后修改时间
     */
    private Date lastupdatetime;

    /**
     * 删除咨询登记人员
     */
    private String deletename;

    /**
     * 删除咨询登记时间
     */
    private Date deletetime;

    /**
     * 学生电话
     */
    private String phone;

//    咨询方式条数
    private Integer total;

    //回访次数
    private Integer total1;
    /**
     * 课程详细编号
     */
    private Detailcourse detailcourse;
    private Integer detailcourseId;

    /**
     * 课程编号
     */
    private Integer courseId;

    /**
     * 接待人
     */
    private Integer empId;

    private Course course;

    private Emp emp;

    private Source source;

    private static final long serialVersionUID = 1L;

}