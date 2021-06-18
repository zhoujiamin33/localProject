package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.DetailsupplementaryDao;
import com.trkj.thirdproject.dao.SupplementaryDao;
import com.trkj.thirdproject.entity.Detailsupplementary;
import com.trkj.thirdproject.entity.Supplementary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SupplementaryServiceImpl implements SupplementaryService {
    @Autowired
    private SupplementaryDao supplementaryDao;
    @Autowired
    private DetailsupplementaryDao detailsupplementaryDao;
    @Override
    public Supplementary insertSelective(Supplementary record) {
      supplementaryDao.insertsupplementary(record);
        return record;
    }

    @Override
    public Detailsupplementary insertSelective(Detailsupplementary detailsupplementary) {
       detailsupplementaryDao.insertSelective(detailsupplementary);
        return detailsupplementary;
    }
}
