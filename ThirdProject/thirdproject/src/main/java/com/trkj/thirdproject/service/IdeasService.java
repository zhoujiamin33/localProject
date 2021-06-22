package com.trkj.thirdproject.service;


import com.trkj.thirdproject.entity.Ideas;

import java.util.List;

public interface IdeasService {
    List<Ideas> selectAllsd();

    List<Ideas> selectAllfc();

    Ideas updateByPrimaryKey(Ideas ideas);
}
