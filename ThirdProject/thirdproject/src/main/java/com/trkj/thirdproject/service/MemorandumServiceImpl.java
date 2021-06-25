package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.MemorandumDao;
import com.trkj.thirdproject.entity.Memorandum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class MemorandumServiceImpl implements MemorandumService {
    @Resource
    private MemorandumDao memorandumDao;

    @Override
    public Memorandum insert(Memorandum memorandum) {
        memorandumDao.insert(memorandum);
        return memorandum;
    }

    @Override
    public List<Memorandum> selectAllMemorandum() {
        return memorandumDao.selectAllMemorandum();
    }
}
