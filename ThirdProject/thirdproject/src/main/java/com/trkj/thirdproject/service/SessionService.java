package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Session;

import java.util.List;

public interface SessionService {
    List<Session> selectAIISessions();
    Session addSession(Session session);
    Session updateSession(Session session);
    void delSession(int SessionId);
}
