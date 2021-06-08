package com.trkj.thirdproject.dao;

import com.trkj.thirdproject.entity.Suggest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuggestDao {
    int deleteByPrimaryKey(Integer suggestId);

    int insert(Suggest record);

    int insertSelective(Suggest record);

    Suggest selectByPrimaryKey(Integer suggestId);

    int updateByPrimaryKeySelective(Suggest record);

    int updateByPrimaryKey(Suggest record);

    List<Suggest> findAllSuggest();

    int DelAuggest (Suggest suggest);

    int UpdateSuggest(Suggest suggest);

    List<Suggest> findNameSuggest(String name);
}