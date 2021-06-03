package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * entryfees
 * @author 
 */
@Data
public class Entryfees implements Serializable {
    /**
     * 报班缴费编号
     */
    private Integer feesId;

    /**
     * 单据号
     */
    private String feesName;

    /**
     * 咨询登记编号
     */
    private Integer registerId;

    /**
     * 应收金额
     */
    private BigDecimal feesReceivable;

    /**
     * 缴费方式
     */
    private Integer feesType;

    /**
     * 预交金额
     */
    private BigDecimal feesAdvance;

    /**
     * 实收金额
     */
    private BigDecimal receipts;

    /**
     * 缴费状态
     */
    private Integer feesState;

    /**
     * 财务审核人
     */
    private String approvalname;

    /**
     * 财务审核时间
     */
    private Date approvaltime;

    /**
     * 撤销审核人
     */
    private String revokeappname;

    /**
     * 撤销审核时间
     */
    private String revokeapptime;

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

    private Register register;

    private static final long serialVersionUID = 1L;
}