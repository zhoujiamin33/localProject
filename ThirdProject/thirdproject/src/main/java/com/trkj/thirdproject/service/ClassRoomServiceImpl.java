package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClassroomDao;
import com.trkj.thirdproject.entity.Classroom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Resource
    private ClassroomDao classdao;
    @Override
    public List<Classroom> findAllRoom() {
        return classdao.findAllRoom();
    }

    @Override
    public Classroom insert(Classroom classroom) {
        classroom.setAddtime(new Date());
        classdao.insert(classroom);
        return classroom;
    }

    @Override
    public Classroom updateByKey(Classroom classroom) {
        classroom.setUpdatetime(new Date());
        classdao.updateByKey(classroom);
        return classroom;
    }
}
