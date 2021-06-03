package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * source
 * @author 
 */
@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
public class Source implements Serializable {
    /**
     * 生源渠道编号
     */
    private Integer sourceId;

    /**
     * 生源渠道名称
     */
    private String sourceName;

    /**
     * 新增渠道职工
     */
    private String addname;

    /**
     * 新增渠道当前时间
     */
    private Date addtime;


    /**
     * 最后修改人员
     */
    private String lastupdatename;

    /**
     * 最后修改时间
     */
    private Date lastupdatetime;

    /**
     * 删除渠道人员
     */
    private String deletename;

    /**
     * 删除渠道时间
     */
    private Date deletetime;

    /**
     * 是否审核
     */
    private Integer isexamine;

    /**
     * 审核时间
     */
    private Date lastexaminetime;

    /**
     * 审核人员
     */
    private String lastexaminename;

    /**
     * 审核时间
     */
    private Date lastrevoketime;

    /**
     * 审核人员
     */
    private String lastrevokename;

    private static final long serialVersionUID = 1L;
}