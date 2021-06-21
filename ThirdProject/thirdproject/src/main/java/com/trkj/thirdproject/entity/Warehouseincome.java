package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * WarehouseIncome
 * @author 
 */
@Data
public class Warehouseincome implements Serializable {
    /**
     * 教材收入编号
     */
    private Integer warehouseincomeId;

    /**
     * 单据号
     */
    private String refundName;

    /**
     * 收入日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date refundDate;

    /**
     * 教材出库总编号
     */
    private Integer bookdeliveryId;

    /**
     * 收入明细
     */
    private String refundDetails;

    /**
     * 已售数量
     */
    private Integer refundCount;

    /**
     * 收支总额
     */
    private BigDecimal totalmoney;
    private int bookId;

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
     * 审核人
     */
    private String approvalname;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date approvaltime;

    /**
     * 审批
     */
    private Integer approval;

    /**
     * 撤销审核人
     */
    private String revokeappname;

    /**
     * 撤销审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date revokeapptime;

    private int timeliness;
    private static final long serialVersionUID = 1L;
}