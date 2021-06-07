package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.EmpDao;
import com.trkj.thirdproject.entity.Emp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService
{
    @Autowired
    private EmpDao empDao;
    @Override
    public Emp insert(Emp record) {
        empDao.AddEmp(record);
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
        empDao.updateByPrimaryKey(emp);
        return emp ;
    }

    @Override
    public List<Emp> findalls(String select,String input) {
        return empDao.findalls(select,input);
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

}
