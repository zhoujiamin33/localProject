package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * studentoutstanding
 * @author 
 */
@Data
public class Studentoutstanding implements Serializable {
    /**
     * 欠费补缴编号
     */
    private Integer outstandingId;

    /**
     * 报班缴费编号
     */
    private Integer feesId;

    /**
     * 单据号
     */
    private String outstandingName;

    /**
     * 补缴日期
     */
    private Date outstandingDate;

    /**
     * 补缴金额
     */
    private BigDecimal alongmoney;

    /**
     * 累计欠费
     */
    private BigDecimal accumulated;

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
     * 审核人
     */
    private String approvalname;

    /**
     * 审核时间
     */
    private Date approvaltime;

    /**
     * 撤销审核人
     */
    private String revokeappname;

    /**
     * 撤销审核时间
     */
    private Date revokeapptime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private  Entryfees entryfees;

    private static final long serialVersionUID = 1L;
}