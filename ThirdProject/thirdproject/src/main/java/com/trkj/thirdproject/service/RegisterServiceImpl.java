package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.RegisterDao;
import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.entity.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Autowired
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
        registerDao.updateByPrimaryKey(register);
        register.setLastupdatetime(new Date());
        return register;
    }
    //咨询登记批量删除修改时效性
    @Override
    public int delstuRegTime(List<Integer>RegisterId){
        Register register=new Register();
        for (int unitid :RegisterId){
            register.setDeletetime(new Date());
            registerDao.delstuRegTime(unitid);
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

    //报表统计中统计每种咨询方式的使用次数
    @Override
    public List<Register> ConsultationmodeStatistics(){
        return registerDao.ConsultationmodeStatistics();
    }

    //咨询登记分页显示
    @Override
    public List<Register> selectAIIRegister() {
        log.debug("开始查询所有咨询登记");
        return registerDao.selectAIIRegister();
    }

//    咨询登记模糊查询
    @Override
    public List<Register> selectRegisterlivery(String value, String input) {
        return registerDao.selectRegisterlivery(value,input);
}

}
