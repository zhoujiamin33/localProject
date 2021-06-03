package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * session
 * @author 
 */
@Data
public class Session implements Serializable {
    /**
     * 年届编号
     */
    private Integer sessionId;

    /**
     * 年届名称
     */
    private String sessionName;

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
     * 最后删除人员
     */
    private String deletename;

    /**
     * 最后删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}