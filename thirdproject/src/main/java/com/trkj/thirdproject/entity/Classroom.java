package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * classroom
 * @author 
 */
@Data
public class Classroom implements Serializable {
    /**
     * 教室编号
     */
    private Integer classroomId;

    /**
     * 教室名称
     */
    private String classroomName;

    /**
     * 容纳量
     */
    private Integer cacacity;

    private String place;

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