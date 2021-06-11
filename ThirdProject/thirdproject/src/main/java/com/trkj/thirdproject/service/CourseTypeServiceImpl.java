package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ClasstypeDao;
import com.trkj.thirdproject.entity.Classtype;
import com.trkj.thirdproject.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CourseTypeServiceImpl implements CourseTypeService {
    @Resource
    private ClasstypeDao classtypedao;

    @Override
    public List<Classtype> selectAllClassType() {
        return  classtypedao.selectAllClassType();
    }

    @Override
    public List<Classtype> selectByname(String ClasstypeName) {
        log.debug(ClasstypeName+"------------");
        return classtypedao.selectByname(ClasstypeName);
    }

    @Override
    public Classtype insert(Classtype classtype) {
         classtypedao.insert(classtype);
         return classtype;
    }

    @Override
    public Classtype updateType(Classtype classtype) {
        classtypedao.updateByPrimaryKey(classtype);
        return classtype;
    }

//    @Override
//    public Classtype selectByPrimaryKey(Integer classtypeId) {
//        Classtype classtype=classtypedao.selectByPrimaryKey(classtypeId);
//        return  classtype;
//    }

    @Override
    public int updateCourseType(List<Integer> classtypeId, String deletename, Date deleteTime) {
        for(int classtypeid:classtypeId){
            classtypedao.updateCourseType(classtypeid,deletename,deleteTime);
        }
        return 1;
    }

}
