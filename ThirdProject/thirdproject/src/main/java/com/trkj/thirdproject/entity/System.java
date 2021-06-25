package com.trkj.thirdproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import antlr.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * system
 * @author
 */
@Data
public class System implements Serializable {
    /**
     * 制度编号
     */
    private Integer systemId;

    /**
     * 制度类型表
     */
    private Integer systemtypeId;

    /**
     * 制度主题
     */
    private String systemTheme;

    /**
     * 发文单位
     */
    private Integer deptId;

    /**
     * 制度内容
     */
    private String systemContent;

    /**
     * 制度状态
     */
    private Integer systemState;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * 录入人员
     */
    private String addname;

    /**
     * 录入时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date addtime;

    /**
     * 最后发布人
     */
    private String publishname;

    /**
     * 最后发布时间
     */
    private Date publishtime;

    /**
     * 最后暂停人
     */
    private String suspendname;

    /**
     * 最后暂停时间
     */
    private Date suspendtime;

    /**
     * 最后修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
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

    private Systemtype systemtype;

    private List<Emp> emps;

    private String names;

    private static final long serialVersionUID = 1L;
}