package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.SessionDao;
import com.trkj.thirdproject.entity.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionDao sessionDao;
    @Override
    public List<Session> selectAIISessions() {
        log.debug("开始查询所有年届");
        return sessionDao.selectAIISessions();
    }

    @Override
    public Session addSession(Session session) {
         log.debug("开始插入信息");
         sessionDao.insert(session);
         return session;
    }

    @Override
    public Session updateSession(Session session) {
         log.debug("修改成功");
         sessionDao.updateByPrimaryKey(session);
         return session;
    }

    @Override
    public void delSession(int SessionId) {

    }
}
