package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Memorandumattachment;
import com.trkj.thirdproject.entity.Register;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MemorandumattachmentService {
    //查询
    List<Memorandumattachment>selectMemorandumAttachment();
    //分页
    List<Memorandumattachment>selectAIIMem();
    //批量审批修改招生状态
    int PiliangZssp (List<Integer>MemorandumattachmentId, Date JWExamineTime);
    //学院交接模糊查询
    List<Memorandumattachment> selectMemlivery(@Param("value")String value, @Param("input") String input);


}
