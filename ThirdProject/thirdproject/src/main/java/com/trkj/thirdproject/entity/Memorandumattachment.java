package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * memorandumattachment
 * @author 
 */
@Data
public class Memorandumattachment implements Serializable {
    /**
     * 交接编号
     */
    private Integer memorandumattachmentId;

    /**
     * 咨询登记编号
     */
    private List<Register> register;
    private Integer registerId;


    /**
     * 招生审核状态
     */
    private String zsisexamine;

    /**
     * 招生审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zsexaminetime;

    /**
     * 招生审核人员
     */
    private String zsexaminename;

    /**
     * 招生撤销审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zsrevoketime;

    /**
     * 招生撤销审核人员
     */
    private String zsrevokename;

    /**
     * 教务审核状态
     */
    private String jwisexamine;

    /**
     * 教务审核时间
     */
    private Date jwexaminetime;

    /**
     * 教务审核人
     */
    private String jwexaminename;

    /**
     * 教务审核撤销时间
     */
    private Date jwrevoketime;

    /**
     * 教务审核撤销人
     */
    private String jwrevokename;


    private static final long serialVersionUID = 1L;
}