package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.MemorandumattachmentDao;
import com.trkj.thirdproject.entity.Memorandumattachment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MemorandumattachmentServiceImpl implements MemorandumattachmentService {
    @Resource
    private MemorandumattachmentDao memorandumattachmentDao;
    @Override
    public List<Memorandumattachment> selectMemorandumAttachment() {
        return memorandumattachmentDao.selectMemorandumAttachment();
    }
}
