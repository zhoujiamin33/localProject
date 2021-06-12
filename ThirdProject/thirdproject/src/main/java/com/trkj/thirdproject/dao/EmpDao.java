package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface EmpDao {
    int deleteByPrimaryKey(Integer empId);

    int insertSelective(Emp record);

    int updateByPrimaryKeySelective(Emp record);

    //新增
    int AddEmp(Emp record);
    //根据id查询
    Emp selectByPrimaryKey(Integer empId);
    //修改
    int updateByPrimaryKey(Emp record);
    //    查询所有
    List<Emp> selectAllEmp();
    //模糊查询:select是下拉框中的内容；input是文本输入的内容
    List<Emp> findalls(@Param("index")String index,@Param("value")String value);
    //批量删除
    int delstuTimeness(@Param("leavename") String leavename, @Param("leavetime") Date leavetime, @Param("empId")  Integer empId);
    //启动或禁用
    int updatestate(@Param("workersstate") Integer workersstate,@Param("empId") Integer empId);

}