package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.UnitDao;
import com.trkj.thirdproject.entity.Unit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitDao unitDao;
    @Override
    public List<Unit> findAllUnit() {
        return unitDao.fandAllUnit();
    }

    @Override
    public int UnitAdd(Unit unit) {
        unit.setAddname("默认");
        unit.setAddtime(new Date());
        log.debug(unit.toString()+"111");
        return unitDao.insertSelective(unit);
    }

    @Override
    public int UpdateUnit(Unit unit) {
        unit.setUpdatename("默认");
        unit.setUpdatetime(new Date());
        return unitDao.updateByPrimaryKeySelective(unit);
    }

    @Override
    public int delUnit(List<Integer> unitId,String deleteName, Date deleteTime) {
        log.debug(unitId.toString());
        for (int unitid : unitId){
            log.debug(unitId+"删除值的ID"+deleteName);
            unitDao.delUnit(unitid,deleteName,deleteTime);
        }
        return 1;
    }

    @Override
    public int fandUnitTypeId(int id) {
        return unitDao.findUnitType(id);
    }
}
