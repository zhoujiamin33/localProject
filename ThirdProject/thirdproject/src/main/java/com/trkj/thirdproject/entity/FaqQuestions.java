package com.trkj.thirdproject.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * faq_questions
 * @author 
 */
@Data
public class FaqQuestions implements Serializable {
    /**
     * FAQ问答编号
     */
    private Integer faqId;

    /**
     * 问题
     */
    private String problem;

    /**
     * 答案
     */
    private String answer;

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
     * 点击量
     */
    private Integer clickcount;

    /**
     * 时效性
     */
    private Integer timeliness;

    private static final long serialVersionUID = 1L;
}