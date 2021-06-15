package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * returnvisit
 * @author 
 */
@Data
public class Returnvisit implements Serializable {
    /**
     * 回访编号
     */
    private Integer returnvisitId;

    /**
     * 咨询登记编号
     */
    private Integer registerId;

    /**
     * 批注意见
     */
    private String comments;

    /**
     * 回访方式
     */
    private String returnvisitmode;

    /**
     * 回访日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnvisitdate;

    /**
     * 回访反馈
     */
    private String returnvisitback;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 接待人
     */
    private Integer empId;

    private Emp emp;
    private Register register;

    private static final long serialVersionUID = 1L;
}