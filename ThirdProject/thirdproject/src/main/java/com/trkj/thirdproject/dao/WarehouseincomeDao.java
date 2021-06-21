package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Warehouseincome;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseincomeDao {
    int deleteByPrimaryKey(Integer warehouseincomeId);
    //新增教材出库收入
    int insert(Warehouseincome warehouseincome);

    int insertSelective(Warehouseincome record);

    Warehouseincome selectByPrimaryKey(Integer warehouseincomeId);

    int updateByPrimaryKeySelective(Warehouseincome record);

    int updateByPrimaryKey(Warehouseincome record);
    //查询所有出库收入
    List<Warehouseincome> selectAllincome();
    //撤销审核
    int updateReApproval(Warehouseincome warehouseincome);
    //审核
    int updateApproval(Warehouseincome warehouseincome);
}