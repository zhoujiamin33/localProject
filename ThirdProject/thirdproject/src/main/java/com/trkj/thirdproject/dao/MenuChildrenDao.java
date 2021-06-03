package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.MenuChildren;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuChildrenDao {
    int deleteByPrimaryKey(Integer childrenId);

    int insert(MenuChildren record);

    int insertSelective(MenuChildren record);

    MenuChildren selectByPrimaryKey(Integer childrenId);

    int updateByPrimaryKeySelective(MenuChildren record);

    int updateByPrimaryKey(MenuChildren record);

//    查询
    List<MenuChildren> findChildren();
}