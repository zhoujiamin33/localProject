package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Refund
 * @author 
 */
@Data
public class Refund implements Serializable {
    /**
     * 退费编号
     */
    private Integer refundId;

    /**
     * 退学编号
     */
    private Integer dropId;

    //学员编号
    private Student student;
    private Integer studentId;

    /**
     * 复课编号
     */
    private Integer backId;

    /**
     * 停课编号
     */
    private Integer suspendeId;

    /**
     * 班级编号
     */
    private Integer classesId;

    /**
     * 课程编号
     */
    private Integer courseId;

    /**
     * 课程详细编号
     */
    private Integer detailcourseId;

    /**
     * 退费类型
     */
    private String refundtype;

    /**
     * 回退金额
     */
    private BigDecimal dropMoney;

    /**
     * 退费办理人
     */
    private String addname;

    /**
     * 退费办理时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date addtime;

    /**
     * 删除人
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private String deletename;

    /**
     * 删除时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date deletetime;

    /**
     * 回退金额审批
     */
    private Integer cwApproval;

    /**
     * 回退金额审核人
     */
    private String cwAppname;

    /**
     * 回退金额审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date cwApptime;

    /**
     * 回退金额撤销审核人
     */
    private String cwDropappname;

    /**
     * 回退金额撤销审核时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date cwDropapptime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}