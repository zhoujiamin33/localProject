package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.thirdproject.service.AnnouncementService;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * announcement
 * @author
 */
@Data
public class Announcement implements Serializable {
    /**
     * 公告编号
     */
    private Integer announcementId;

    /**
     * 公告类型
     */
    private Integer announcementtypeId;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;

    /**
     * 公告主题
     */
    private String announcementTheme;

    /**
     * 公告内容
     */
    private String announcementContent;

    /**
     * 公告状态
     */
    private Integer announcementState;

    /**
     * 录入人员
     */
    private String addname;

    /**
     * 录入时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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

    private List<Emp> emps;

    private static final long serialVersionUID = 1L;
}