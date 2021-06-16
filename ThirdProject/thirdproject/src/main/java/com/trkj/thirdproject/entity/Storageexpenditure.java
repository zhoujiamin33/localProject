package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * StorageExpenditure
 * @author 
 */
@Data
public class Storageexpenditure implements Serializable {
    /**
     * 教材入库支出编号
     */
    private Integer expensesId;

    /**
     * 单据号
     */
    private String expensesName;

    /**
     * 支出日期
     */
    private Date expensesDate;

    /**
     * 支出明细
     */
    private String expensesDetails;

    /**
     * 教材入库编号
     */
    private Integer mbookstorageId;

    /**
     * 已入数量
     */
    private Integer refundCount;


    /**
     * 收支总额
     */
    private BigDecimal totalmoney;

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
     * 审核人
     */
    private String approvalname;

    /**
     * 审核时间
     */
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
    private Date revokeapptime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}