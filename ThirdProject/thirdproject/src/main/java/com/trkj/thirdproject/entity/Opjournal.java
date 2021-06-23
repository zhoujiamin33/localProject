package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * OpJournal
 * @author 
 */
@Data
public class Opjournal implements Serializable {
    /**
     * 日志编号
     */
    private Integer opjournalId;

    /**
     * 职员编号
     */
    private Integer empId;

    /**
     * 操作内容
     */
    private String opcontent;

    /**
     * 操作时间
     */
    private Date optime;

    private static final long serialVersionUID = 1L;
}