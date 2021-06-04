package com.trkj.thirdproject.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * unittype
 * @author 
 */
@Data
public class Unittype implements Serializable {
    /**
     * 编号
     */
    private Integer unittypeId;

    /**
     * 单位类型名称
     */
    private String unittypeName;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date addtime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}