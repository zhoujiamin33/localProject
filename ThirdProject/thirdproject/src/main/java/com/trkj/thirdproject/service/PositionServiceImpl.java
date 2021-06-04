package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.PositionDao;
import com.trkj.thirdproject.entity.Position;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;
    //查询所有
    @Override
    public List<Position> selectAllposition() {
        return positionDao.selectAllposition();
    }

    //    新增

    @Override
    public Position addposition(Position position) {
        log.debug(position.toString());
        positionDao.insertSelective(position);
        return position;
    }
    //修改
    @Override
    public Position updateposition(Position position) {
        positionDao.updateByPrimaryKeySelective(position);
        return position;
    }
    //    删除
    @Override
    public void deleteposition(Integer positionId) {
        positionDao.deleteByPrimaryKey(positionId);
    }

    @Override
    public List<Position> selectByname(String positionName) {
        return positionDao.selectByname(positionName);
    }
    //删除后为已过期
    @Override
    public int delTimeLiness( Integer positionId) {
        return positionDao.delTimeLiness(positionId);
    }
    //    <!--  删除之后显示未过期的职位-->
    @Override
    public List<Position> selectTimeLiness() {
        return positionDao.selectTimeLiness();
    }
//    @Override
//    public Page<Position> findall(Pageable pageable) {
//        return positionDao.selectAllposition();
//    }

}
