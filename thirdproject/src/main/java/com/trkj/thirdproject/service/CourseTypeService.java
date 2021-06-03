package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Classtype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface CourseTypeService {
    //查询所有
    List<Classtype> selectAllClassType();

    //    模糊查询
    List<Classtype> selectByname(String ClasstypeName);
    //    新增
    Classtype insert(Classtype classtype);

    //    修改
    Classtype updateType(Classtype classtype);

}
