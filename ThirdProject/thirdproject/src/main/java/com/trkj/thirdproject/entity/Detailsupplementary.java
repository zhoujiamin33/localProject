package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * DetailSupplementary
 * @author 
 */
@Data
public class Detailsupplementary implements Serializable {
    /**
     * 课程详细编号
     */
    private Integer detailsupplementaryId;

    /**
     * 补报课程编号
     */
    private  Supplementary supplementary;
    private Integer supplementaryId;

    /**
     * 课程详细名称
     */
    private String detailsupplementaryName;

    /**
     * 新增人员
     */
    private String addname;

    /**
     * 新增时间
     */
    private Date addtime;

    /**
     * 删除人员
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 费用总额
     */
    private BigDecimal allprice;

    private static final long serialVersionUID = 1L;
}