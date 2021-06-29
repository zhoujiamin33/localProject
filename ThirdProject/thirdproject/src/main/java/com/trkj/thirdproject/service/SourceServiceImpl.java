package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SourceDao;
import com.trkj.thirdproject.entity.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceDao sourceDao;
    //分页
    @Override
    public List<Source> selectAIISources() {
        log.debug("开始分页查询生源渠道信息");
        return sourceDao.selectAIISources();
    }

    @Override
    public Source addSource(Source source) {
        log.debug("开始插入信息");
        sourceDao.insert(source);
        return source;
    }

    @Override
    public Source updateSource(Source source) {
         log.debug("修改成功");
         sourceDao.updateByPrimaryKey(source);
         return source;
    }

    @Override
    public void aelSource(int sourceId) {

    }

    //模糊查询
    @Override
    public List<Source> selectSourceFuzzyquery(String value, String input) {
        return sourceDao.selectSourceFuzzyquery(value,input);
    }
}
