package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Memorandum
 * @author 
 */
@Data
public class Memorandum implements Serializable {
    /**
     * 备忘录编号
     */
    private Integer memorandumId;

    /**
     * 备忘录标题
     */
    private String memorandumTitle;

    /**
     * 备忘录内容
     */
    private String memorandumName;

    /**
     * 类型
     */
    private String memorandumType;

    /**
     * 开始时间
     */
    private Date starttime;

    /**
     * 结束时间
     */
    private Date endtime;

    /**
     * 删除时间
     */
    private Date deltetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}