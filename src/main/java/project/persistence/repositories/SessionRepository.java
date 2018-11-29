package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Session;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session save(Session session);

    void delete(Session session);

    List<Session> findAll();

    @Query(value = "SELECT p FROM Session p WHERE p.id = ?1")
    Session findOne(int id);

    List<Session> findByName(String name);
    
    List<Session> findByType(String type);

    @Query(value = "SELECT p FROM Session p WHERE p.userID = ?1 OR p.userID = 0")
	List<Session> findAllUserSessions(int id);
    
}
