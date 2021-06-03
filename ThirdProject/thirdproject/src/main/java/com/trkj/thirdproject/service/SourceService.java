package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Source;

import java.util.List;

public interface SourceService {
    List<Source> selectAIISources();
    Source addSource(Source source);
    Source updateSource(Source source);
    void aelSource(int sourceId);
}
