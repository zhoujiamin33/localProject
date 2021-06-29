package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Source;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourceService {
    List<Source> selectAIISources();
    Source addSource(Source source);
    Source updateSource(Source source);
    void aelSource(int sourceId);
    // 模糊查询
    List<Source> selectSourceFuzzyquery(@Param("value")String value, @Param("input") String input);
}
