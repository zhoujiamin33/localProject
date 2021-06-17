package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Suggest;

import java.util.List;

public interface SuggestService {

    Suggest insertSelective(Suggest record);

    List<Suggest> findAllSuggest();

    Suggest DelAuggest(Suggest suggest);

    Suggest UpdateSuggest(Suggest suggest);

    List<Suggest> findNameSuggest(String name);

}
