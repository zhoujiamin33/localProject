package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Unittype;

import java.util.List;

public interface UnitTypeService {
    List<Unittype> selectAllUnitType();
    int UnitTypeAdd(Unittype unittype);
    int UnitTypeUpdate(Unittype unittype);
    int UnitTypeDelete(int unittypeId);
    int updateTimeLiness(Unittype unittype);
}
