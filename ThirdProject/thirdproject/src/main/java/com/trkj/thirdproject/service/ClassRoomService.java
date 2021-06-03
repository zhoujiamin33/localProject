package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Classroom;

import java.util.List;

public interface ClassRoomService {
    List<Classroom> findAllRoom();
    Classroom insert(Classroom classroom);
    Classroom updateByKey(Classroom classroom);
}
