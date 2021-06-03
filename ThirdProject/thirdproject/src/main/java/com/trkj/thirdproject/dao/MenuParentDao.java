package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.MenuParent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuParentDao {
    int deleteByPrimaryKey(Integer parentId);

    int insert(MenuParent record);

    int insertSelective(MenuParent record);

    MenuParent selectByPrimaryKey(Integer parentId);

    int updateByPrimaryKeySelective(MenuParent record);

    int updateByPrimaryKey(MenuParent record);

    List<MenuParent> findParent();
}