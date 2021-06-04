package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Unit;

import java.util.Date;
import java.util.List;

public interface UnitService {
    List<Unit>findAllUnit();
    int UnitAdd(Unit unit);
    int UpdateUnit(Unit unit);
    int delUnit(List<Integer> multipleSelection, String nu, Date tm);
    int fandUnitTypeId(int id);
}
