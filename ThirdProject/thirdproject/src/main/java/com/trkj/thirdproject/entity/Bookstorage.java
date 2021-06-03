package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * bookstorage
 * @author 
 */
@Data
public class Bookstorage implements Serializable {
    /**
     * 教材入库编号
     */
    private Integer mbookstorageId;

    /**
     * 入库员职工编号
     */
    private Emp emp;
    private Integer empId;

    /**
     * 教材编号
     */
    private Book book;
    private Integer bookId;

    /**
     * 入库数量
     */
    private Integer storagecount;

    /**
     * 入库时间
     */
    private Date storagetime;

    /**
     * 总价
     */
    private BigDecimal totalprice;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 审批
     */
    private Integer approval;

    /**
     * 审核人
     */
    private String appname;

    /**
     * 审核时间
     */
    private Date apptime;

    /**
     * 撤销审核人
     */
    private String revokeAppname;

    /**
     * 撤销审核时间
     */
    private Date revokeApptime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}