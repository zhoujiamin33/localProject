package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * deliveryddetails
 * @author 
 */
@Data
public class Deliveryddetails implements Serializable {
    /**
     * 教材出库编号
     */
    private Integer deliveryddetailsId;

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
     * 教材出库总编号
     */
    private Bookdelivery bookdelivery;
    private Integer bookdeliveryId;

    /**
     * 教材编号
     */
    private Book book;
    private Integer bookId;

    /**
     * 出库数量
     */
    private Integer deliverycount;

    /**
     * 应收金额
     */
    private BigDecimal receivablemoney;


    private static final long serialVersionUID = 1L;
}