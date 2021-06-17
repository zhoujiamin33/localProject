package com.trkj.thirdproject.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * AnnouncementSelect
 * @author 
 */
@Data
public class Announcementselect implements Serializable {
    /**
     * 公告允许查询编号
     */
    private Integer announcementselectId;

    /**
     * 公告编号
     */
    private Integer announcementId;

    /**
     * 允许查看用户编号
     */
    private Integer empId;

    private static final long serialVersionUID = 1L;
}