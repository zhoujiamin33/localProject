package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * position
 * @author 
 */
@Data
public class Position implements Serializable {
    /**
     * 职位编号
     */
    private Integer positionId;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 职位描述
     */
    private String jobdescription;

    /**
     * 新增人
     */
    private String addname;

    /**
     * 新增时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date addtime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}