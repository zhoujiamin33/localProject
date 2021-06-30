package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    List<String> findAuthorityByRoleCodes(@Param("PositionNames") List<String> PositionNames);
    List<SysMenu> findMenusByPositionNames(@Param("PositionNames") List<String> PositionNames);
// 查询
List<SysMenu> selectAllmenu();
}