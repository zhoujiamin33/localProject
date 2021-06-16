package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.RegisterDao;
import com.trkj.thirdproject.entity.Register;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return registerDao.showstudent();
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
    //咨询登记批量删除修改时效性
    @Override
    public int delstuRegTime(List<Integer>RegisterId, String lastupdatename, Date lastupdatetime){
        for (int unitid :RegisterId){
            registerDao.delstuRegTime(unitid,lastupdatename,lastupdatetime);
        }
        return 1;
    }

    @Override
    public List<Register> selectAttentState() {
        return registerDao.selectAttentState();
    }

    @Override
    public Register selectByregisterId(Integer registerId) {
        log.debug(registerId+"1111111111111");
        return registerDao.selectByregisterId(registerId);
    }

    @Override
    public int updatepaystate(Integer registerId) {
        return  registerDao.updatepaystate(registerId);
    }
}
