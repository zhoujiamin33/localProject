package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * bookdelivery
 * @author 
 */
@Data
public class Bookdelivery implements Serializable {
    /**
     * 教材出库总编号
     */
    private Integer bookdeliveryId;

    /**
     * 学员编号
     */
    private Student student;
    private Integer studentId;

    /**
     * 职工编号
     */
    private Emp emp;
    private Integer empId;

    /**
     * 销售编号
     */
    private String salenumber;

    /**
     * 出库时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deliverytime;

    /**
     * 总价格
     */
    private BigDecimal tota;


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