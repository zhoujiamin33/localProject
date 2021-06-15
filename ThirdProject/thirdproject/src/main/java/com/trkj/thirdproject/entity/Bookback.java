package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * bookback
 * @author 
 */
@Data

public class Bookback implements Serializable {
    /**
     * 教材破损编号
     */
    private Integer bookbackId;

    /**
     * 破损处理人员
     */
    private Emp emp;
    private Integer empId;

    /**
     * 教材编号
     */
    private Book book;
    private Integer bookId;

    /**
     * 破损处理日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date storagetime;

    /**
     * 破损原因描述
     */
    private String causeofdamage;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

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

    private Integer backcount;

    private BigDecimal backmoney;

    private String returnnumber;

    private static final long serialVersionUID = 1L;
}