package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.ReturnvisitDao;
import com.trkj.thirdproject.entity.Register;
import com.trkj.thirdproject.entity.Returnvisit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ReturnvisitServiceImpl implements ReturnvisitService {

    @Resource
    private ReturnvisitDao returnvisitDao;
    @Override
    public List<Returnvisit>  selectReturnvisit(Integer registerId) {
        return returnvisitDao.selectReturnvisit(registerId);
    }
    @Override
    public Returnvisit inserRreturnvisit(Returnvisit returnvisit){
        returnvisitDao.inserRreturnvisit(returnvisit);
        return  returnvisit;
    }

    @Override
    public int delstuRetTime(List<Integer>Returnvisit_Id){
        for (int unitid :Returnvisit_Id){
            returnvisitDao.delstuRetTime(unitid);
        }
        return 1;
    }

    //回访次数
    @Override
    public List<Returnvisit> Numberofreturnvisits(){
        return returnvisitDao.Numberofreturnvisits();
    }
}
