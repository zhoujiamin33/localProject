package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SuggestDao;
import com.trkj.thirdproject.entity.Suggest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SuggestServiceImpl implements SuggestService {
    @Autowired
    private SuggestDao suggestDao;
    @Override
    public Suggest insertSelective(Suggest record) {
        record.setAddtime(new Date());
        suggestDao.insertSelective(record);
        return record;
    }

    @Override
    public List<Suggest> findAllSuggest() {
        return suggestDao.findAllSuggest();
    }

    @Override
    public Suggest DelAuggest(Suggest suggest) {
        suggest.setDeletetime(new Date());
        suggestDao.DelAuggest(suggest);
        return suggest;
    }

    @Override
    public Suggest UpdateSuggest(Suggest suggest) {
        suggest.setUpdatetime(new Date());
        suggestDao.UpdateSuggest(suggest);
        return suggest;
    }

    @Override
    public List<Suggest> findNameSuggest(String name) {
        return suggestDao.findNameSuggest(name);
    }
}
