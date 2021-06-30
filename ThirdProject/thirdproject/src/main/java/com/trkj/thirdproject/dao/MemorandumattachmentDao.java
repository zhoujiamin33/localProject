package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Memorandumattachment;
import com.trkj.thirdproject.entity.Register;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface MemorandumattachmentDao {
    int deleteByPrimaryKey(Integer memorandumattachmentId);

    int insert(Memorandumattachment record);

    int insertSelective(Memorandumattachment record);

    Memorandumattachment selectByPrimaryKey(Integer memorandumattachmentId);

    List<Memorandumattachment> selectMemorandumAttachment();
//    分页显示
    List<Memorandumattachment> selectAIIMem();
    //模糊查询
    List<Memorandumattachment> selectMemlivery(@Param("value")String value, @Param("input") String input);


    int PiliangZssp(@Param("memorandumattachmentId" ) int MemorandumAttachment_Id, @Param("jwexaminetime") Date JWExamineTime);


    int updateByPrimaryKeySelective(Memorandumattachment record);

    int updateByPrimaryKey(Memorandumattachment record);

    //<!--  查询所有（咨询登记）-->

    List<Memorandumattachment> selectregister(Integer memorandumattachmentid);

    //<!--  在学员交接表查询所有（咨询登记）-->

    List<Memorandumattachment> selectregister();
//    根据咨询编号查看交接内容
    Memorandumattachment selectregisterID(Integer registerId);
}