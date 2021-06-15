package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * systemselect
 * @author 
 */
@Data
public class Systemselect implements Serializable {
    /**
     * 制度类型编号
     */
    private Integer systemselectId;

    /**
     * 规章制度编号
     */
    private Integer systemId;

    /**
     * 允许查看用户编号
     */
    private Integer empId;

    private Emp emp;
    private System system;
    private static final long serialVersionUID = 1L;
}