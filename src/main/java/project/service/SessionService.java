package project.service;

import java.util.List;

import project.persistence.entities.PostitNote;
import project.persistence.entities.Session;

public interface SessionService {

    Session save(Session session);

    void delete(Session session);

    List<Session> findAllSessions();

    List<Session> findAllSessionsReverseOrder();

    Session findSession(int id);

    List<Session> findSessionByName(String name);

    List<Session> findSessionByType(String type);

}
