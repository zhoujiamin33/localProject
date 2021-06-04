package com.trkj.thirdproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    /**
     * 学生编号
     */
    private Integer studentId;

    /**
     * 学生名称
     */
    private String studentName;

    /**
     * 学生状态
     */
    private Integer studentState;

    /**
     * 班级编号
     */
    private List<Classes> classes;
    private Integer classesId;

    /**
     * 生源渠道编号
     */
    private Source source;
    private Integer sourceId;

    /**
     * 咨询登记编号
     */
    private Register register;
    private Integer registerId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 联系电话
     */
    private String studentPhone;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 照片地址
     */
    private String imgaddress;

    /**
     * 家长姓名
     */
    private String parentname;

    /**
     * 家长电话
     */
    private String parentphone;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 入学备注
     */
    private String entrance;

    /**
     * 修改人
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
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;

    /**
     * 就读时间
     */
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date studytime;

    private static final long serialVersionUID = 1L;
}