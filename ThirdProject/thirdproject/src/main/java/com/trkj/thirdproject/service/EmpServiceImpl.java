package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EmpDao;
import com.trkj.thirdproject.entity.Emp;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public Emp insert(Emp record) {
        record.setEnterpriseId(1);//公司编号固定
//        record.setJobnumber("zz"+ record.getAddtime().getTime());
        empDao.insertSelective(record);
        return record;
    }

    @Override
    public List<Emp> selectAllEmp() {
        return empDao.selectAllEmp();
    }

    @Override
    public void delectEmp(Integer EmpId) {
empDao.deleteByPrimaryKey(EmpId);
    }

    @Override
    public Emp updateEmp(Emp emp) {
        emp.setUpdatetime(new Date());
        empDao.updateByPrimaryKeySelective(emp);
        return emp ;
    }

    @Override
    public List<Emp> findalls(String index,String value) {
        return empDao.findalls(index,value);
    }
//批量删除
    @Override
    public void delstuTimeness(String leavename, Date leavetime, List<Integer> empId) {
        for (Integer e : empId) {
             empDao.delstuTimeness(leavename, leavetime, e);
        }
    }

    @Override
    public void updatestate(Integer workersstate, List<Integer> empId) {
        for (Integer e : empId) {
             empDao.updatestate(workersstate, e);
        }

    }
//已限制
    @Override
    public List<Emp> selectByPrimary() {
        List<Emp> empList=empDao.selectByPrimary();
        return empList;
    }
//未限制
    @Override
    public List<Emp> selectByPrimarywei() {
        List<Emp> empList=empDao.selectByPrimarywei();
        return empList;
    }

    @Override
    public List<Emp> selectEmpteacher() {
        return empDao.selectEmpteacher();
    }

}
