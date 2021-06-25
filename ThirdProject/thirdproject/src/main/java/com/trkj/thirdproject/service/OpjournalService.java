package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Opjournal;

import java.util.List;

public interface OpjournalService {
    Opjournal addopjournal(Opjournal opjournal);
    Opjournal updateopjournal(Opjournal opjournal);
    int deleteopjournal(Integer opjournalId);
    List<Opjournal> selectByPrimary();
}
