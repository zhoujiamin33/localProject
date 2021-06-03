package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Entryfees;

import java.util.List;

public interface EntryfeesService {
    List<Entryfees> selectKey();
    Entryfees insertentryfees(Entryfees entryfees);
}
