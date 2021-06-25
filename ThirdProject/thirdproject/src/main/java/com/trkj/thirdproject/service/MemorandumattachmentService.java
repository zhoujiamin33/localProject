package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Memorandumattachment;

import java.util.Date;
import java.util.List;

public interface MemorandumattachmentService {
    //查询
    List<Memorandumattachment>selectMemorandumAttachment();
    //分页
    List<Memorandumattachment>selectAIIMem();
    //批量审批修改招生状态
    int PiliangZssp (List<Integer>MemorandumattachmentId, Date JWExamineTime);

}
