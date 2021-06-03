package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EntryfeesDao;
import com.trkj.thirdproject.entity.Entryfees;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class EntryfeesServiceImpl implements EntryfeesService {
    @Resource
    private EntryfeesDao entryfeesdao;
    @Override
    public List<Entryfees> selectKey() {
        return entryfeesdao.selectKey();
    }

    @Override
    public Entryfees insertentryfees(Entryfees entryfees) {
        entryfees.setAddname("Tsm管理员");
        entryfeesdao.insertentryfees(entryfees);
        log.debug("新增报班缴费");
        return entryfees;
    }
}
