package com.trkj.thirdproject.service;



import com.trkj.thirdproject.entity.Bookback;

import java.util.List;

public interface BookbackService {
    List<Bookback> selectAll();

    int deleteByPrimaryKey(int bookbackId);

    Bookback insert(Bookback bookback);
}
