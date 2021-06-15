package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Position;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionDao {
    int deleteByPrimaryKey(Integer positionId);

    int insert(Position record);
    //    新增
    int insertSelective(Position record);
    //修改
    int updateByPrimaryKeySelective(Position record);
    Position selectByPrimaryKey(Integer positionId);

    int updateByPrimaryKey(Position record);

    //查询所有
    List<Position> selectAllposition();



    //分页
//        Page<Position> findAll(Pageable pageable);
    //根据部门名称模糊查询
    List<Position> selectByname(String positionName);
    //删除后为已过期
    int delTimeLiness( Integer positionId);
    //    <!--  删除之后显示未过期的职位-->
    List<Position> selectTimeLiness();
}