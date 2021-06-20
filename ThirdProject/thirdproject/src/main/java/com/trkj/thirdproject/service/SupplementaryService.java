package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Detailsupplementary;
import com.trkj.thirdproject.entity.Supplementary;

import java.util.List;

public interface SupplementaryService {
    Supplementary insertSelective(Supplementary record);
    //新增详细课程
    Detailsupplementary insertSelective(Detailsupplementary record);
    //查看补报课程总表
    List<Supplementary> selectall();
    Supplementary updateByPrimaryKeySelective(Supplementary record);

}
