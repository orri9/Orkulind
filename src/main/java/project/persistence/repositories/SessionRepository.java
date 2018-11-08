package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Session;
import project.persistence.entities.PostitNote;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session save(Session session);

    void delete(Session session);

    
    List<Session> findAll();

    @Query(value = "SELECT p FROM Session p WHERE p.id = ?1")
    Session findSession(int id);

    @Query(value = "SELECT p FROM Session p WHERE p.name = ?1")
    List<Session> findSessionByName(String name);
    
    @Query(value = "SELECT p FROM Session p WHERE p.type = ?1")
    List<Session> findSessionByType(String type);
    
}
