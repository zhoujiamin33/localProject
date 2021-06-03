package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * trainingperiod
 * @author 
 */
@Data
public class Trainingperiod implements Serializable {
    /**
     * 培训时段编号
     */
    private Integer periodId;

    /**
     * 培训时段
     */
    private String period;

    /**
     * 新增人员
     */
    private String addname;

    /**
     * 新增时间
     */
    private Timestamp addtime;

    /**
     * 最后修改人员
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Timestamp updatetime;

    /**
     * 最后删除人员
     */
    private String deletename;

    /**
     * 最后删除时间
     */
    private Timestamp deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}