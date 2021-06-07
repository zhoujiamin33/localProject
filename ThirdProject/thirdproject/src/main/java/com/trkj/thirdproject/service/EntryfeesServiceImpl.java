package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EntryfeesDao;
import com.trkj.thirdproject.dao.StudentoutstandingDao;
import com.trkj.thirdproject.entity.Entryfees;
import com.trkj.thirdproject.entity.Studentoutstanding;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EntryfeesServiceImpl implements EntryfeesService {
    @Resource
    private EntryfeesDao entryfeesdao;
//    @Resource
//    private StudentoutstandingDao outstandingdao;
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

    @Override
    public Entryfees updateapproval(Entryfees entryfees) {
        entryfees.setApprovaltime(new Date());
        entryfees.setApprovalname("admin");
        entryfeesdao.updateapproval( entryfees);
        return entryfees ;
    }

    @Override
    public Entryfees updateRevokeapproval(Entryfees entryfees) {
        entryfees.setRevokeappname("Tsm管理员");
        entryfees.setRevokeapptime(new Date());
        entryfeesdao.updateRevokeapproval(entryfees);
        return entryfees ;
    }

    @Override
    public Entryfees deleteByPrimaryKey(Entryfees entryfees) {
        entryfees.setDeletename("admin");
        entryfees.setDeletetime(new Date());
        entryfeesdao.deleteByPrimaryKey(entryfees);
        return entryfees;
    }


}
