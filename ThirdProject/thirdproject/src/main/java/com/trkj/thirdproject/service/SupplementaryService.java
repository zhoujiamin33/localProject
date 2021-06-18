package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Detailsupplementary;
import com.trkj.thirdproject.entity.Supplementary;

public interface SupplementaryService {
    Supplementary insertSelective(Supplementary record);
    //新增详细课程
    Detailsupplementary insertSelective(Detailsupplementary record);
}
