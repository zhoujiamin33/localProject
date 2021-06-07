package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Memorandumattachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MemorandumattachmentDao {
    int deleteByPrimaryKey(Integer memorandumattachmentId);

    int insert(Memorandumattachment record);

    int insertSelective(Memorandumattachment record);

    Memorandumattachment selectByPrimaryKey(Integer memorandumattachmentId);

    int updateByPrimaryKeySelective(Memorandumattachment record);

    int updateByPrimaryKey(Memorandumattachment record);

    //<!--  查询所有（咨询登记）-->

    List<Memorandumattachment> selectregister(Integer memorandumattachmentid);
}