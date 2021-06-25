package com.trkj.thirdproject.service;


import com.trkj.thirdproject.entity.Ideas;

import java.util.List;

public interface IdeasService {
    List<Ideas> selectAllsd();

    List<Ideas> selectAllfc();

//    List<Ideas> selectAllqb();
//
//    List<Ideas> selectAlldhf();
//
//    List<Ideas> selectAllyhf();

    Ideas updateByPrimaryKey(Ideas ideas);

    Ideas updateneirong(Ideas ideas);

    Ideas insert(Ideas ideas);

    int deleteByPrimaryKey(int ideasId);
}
