package com.trkj.thirdproject.service;



import com.trkj.thirdproject.entity.Bookback;
import com.trkj.thirdproject.entity.Ideas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookbackService {
    List<Bookback> selectAll();

    int deleteByPrimaryKey(int bookbackId);

    Bookback insert(Bookback bookback);

    List<Bookback> selectBookBack(@Param("value")String value, @Param("input") String input);

    Bookback updateByPrimaryKey(Bookback bookback);
}
