package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.MemorandumattachmentDao;
import com.trkj.thirdproject.entity.Memorandumattachment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class MemorandumattachmentServiceImpl implements MemorandumattachmentService {
    @Resource
    private MemorandumattachmentDao memorandumattachmentDao;
    //  显示
    @Override
    public List<Memorandumattachment> selectMemorandumAttachment() {
        return memorandumattachmentDao.selectMemorandumAttachment();
    }
    // 批量审批修改招生状态
    @Override
    public int PiliangZssp(List<Integer> MemorandumattachmentId, Date JWExamineTime){
        for (int unitid :MemorandumattachmentId){
            memorandumattachmentDao.PiliangZssp(unitid,JWExamineTime);
        }
        return 1;
    }

}
