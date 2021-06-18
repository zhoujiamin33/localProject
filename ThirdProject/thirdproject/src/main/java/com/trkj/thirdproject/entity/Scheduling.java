package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Scheduling
 * @author 
 */
@Data
public class Scheduling implements Serializable {
    /**
     * 排课编号
     */
    private Integer schedulingId;

    /**
     * 培训时段编号
     */
    private Trainingperiod period;
    private Integer periodId;

    /**
     * 班级编号
     */
    private Classes classes;
    private Integer classesId;

    /**
     * 上课状态
     */
    private Integer schedulingState;

    /**
     * 新增人员
     */
    private String addname;

    /**
     * 新增时间
     */
    private Date addtime;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

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

    private static final long serialVersionUID = 1L;
}