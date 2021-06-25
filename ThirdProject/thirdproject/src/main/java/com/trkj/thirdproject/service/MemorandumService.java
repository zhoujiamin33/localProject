package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Memorandum;

import java.util.List;

public interface MemorandumService {
    Memorandum insert(Memorandum memorandum);

    List<Memorandum> selectAllMemorandum();
}
