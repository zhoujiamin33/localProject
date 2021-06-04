package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.UnittypeDao;
import com.trkj.thirdproject.entity.Unittype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UnitTypeServiceImpl implements UnitTypeService {
    @Autowired
    private UnittypeDao dao;
    @Override
    public List<Unittype> selectAllUnitType() {
        return dao.selectAllUnitType();
    }

    @Override
    public int UnitTypeAdd(Unittype unittype) {
        unittype.setAddtime(new Date());
        unittype.setTimeliness(0);
        return dao.insert(unittype);
    }

    @Override
    public int UnitTypeUpdate(Unittype unittype) {
        unittype.setUpdatetime(new Date());
        return dao.updateByPrimaryKey(unittype);
    }

    @Override
    public int UnitTypeDelete(int unittypeId) {
        return dao.deleteByPrimaryKey(unittypeId);
    }

    @Override
    public int updateTimeLiness(Unittype unittype) {
        unittype.setDeletetime(new Date());
        unittype.setTimeliness(1);
        return dao.updateTimeLiness(unittype);
    }
}
