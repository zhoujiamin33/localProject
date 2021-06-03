package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * classtype
 * @author 
 */
@Data
public class Classtype implements Serializable {
    /**
     * 课类编号
     */
    private Integer classtypeId;

    /**
     * 课类名称
     */
    private String classtypeName;

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