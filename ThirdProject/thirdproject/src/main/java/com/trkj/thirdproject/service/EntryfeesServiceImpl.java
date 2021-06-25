package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EntryfeesDao;
import com.trkj.thirdproject.entity.Entryfees;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Convert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        entryfees.setAddtime(new Date());
        String number = "B";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = number+ dateFormat.format(new Date()) + entryfees.toString().length();
        entryfees.setFeesName(result);
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

    @Override
    public Entryfees selectByfeeid(Integer feeId) {
        Entryfees entryfees=entryfeesdao.selectByfeeid(feeId);
        return entryfees;
    }

    @Override
    public Entryfees updateFeesAccumulated(Entryfees entryfees) {
        entryfeesdao.updateFeesAccumulated(entryfees);
        return entryfees;
    }

    @Override
    public List<Entryfees> selectBycontion( int ApprovalState, String value2,String input) {
        return entryfeesdao.selectBycontion(ApprovalState, value2,input);
    }
}
