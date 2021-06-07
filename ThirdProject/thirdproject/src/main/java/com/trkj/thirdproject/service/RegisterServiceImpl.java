package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.RegisterDao;
import com.trkj.thirdproject.entity.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterDao registerDao;
    @Override

    public List<Register> selectRegister() {
        return registerDao.selectRegister();
    }

    @Override
    public Register insert(Register register){
        registerDao.insertRegister(register);
        return register;
    }

    @Override
    public Register updateRegister(Register register){
        register.setPlanreturnvisit(new Date());
        registerDao.updateByPrimaryKey(register);

        return register;
    }

    @Override
    public int delstuRegTime(List<Integer>RegisterId, String lastupdatename, Date lastupdatetime){
        for (int unitid :RegisterId){
            registerDao.delstuRegTime(unitid,lastupdatename,lastupdatetime);
        }
        return 1;
    }
}
