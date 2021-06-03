package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * book
 * @author 
 */
@Data
public class Book implements Serializable {
    /**
     * 教材编号
     */
    private Integer bookId;

    /**
     * 教材名称
     */
    private String bookname;

    /**
     * 库存
     */
    private Integer deliverycount;

    /**
     * 教材售价
     */
    private BigDecimal booksprice;

    /**
     * 教材进价
     */
    private BigDecimal bookjprice;

    /**
     * 安全库存
     */
    private Integer safestock;

    /**
     * 出版社
     */
    private String press;

    /**
     * 教材状态
     */
    private Integer state;

    /**
     * 入库量
     */
    private Integer storage;

    private static final long serialVersionUID = 1L;
}