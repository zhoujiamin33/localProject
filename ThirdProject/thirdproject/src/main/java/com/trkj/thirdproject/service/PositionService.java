package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Position;

import java.util.List;

public interface PositionService {
    //查询所有
    List<Position> selectAllposition();
    //    新增
    Position addposition(Position position);
    //修改
    Position updateposition(Position position);
    //删除
    void deleteposition(Integer positionId);
    //分页
//    Page<Position> findall(Pageable pageable);
    //根据部门名称模糊查询
    List<Position> selectByname(String positionName);
    //删除后为已过期
    int delTimeLiness(Integer positionId);
    //    <!--  删除之后显示未过期的职位-->
    List<Position> selectTimeLiness();
}
