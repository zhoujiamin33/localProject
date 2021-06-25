package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Emp emp;
    private Integer empId;

    /**
     * 操作内容
     */
    private String opcontent;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date optime;

    private static final long serialVersionUID = 1L;
}