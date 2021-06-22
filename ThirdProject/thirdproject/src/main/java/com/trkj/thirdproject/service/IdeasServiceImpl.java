package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.IdeasDao;
import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Ideas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class IdeasServiceImpl implements IdeasService {
    @Resource
    private IdeasDao ideasDao;
    @Override
    public List<Ideas> selectAllsd() {
        return ideasDao.selectAllsd();
    }

    @Override
    public List<Ideas> selectAllfc() {
        return ideasDao.selectAllfc();
    }

    @Override
    public Ideas updateByPrimaryKey(Ideas ideas) {
        ideas.setReply("曹操");
        ideasDao.updateByPrimaryKey(ideas);
        return ideas;
    }
}
