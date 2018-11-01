package project.service;

import java.util.List;

import project.persistence.entities.PostitNote;
import project.persistence.entities.Session;




public interface SessionService {

    /**
     * Save a {@link PostitNote}
     * @param postitNote {@link PostitNote} to be saved
     * @return {@link PostitNote} that was saved
     */
    Session save(Session session);

    /**
     * Delete {@link PostitNote}
     * @param postitNote {@link PostitNote} to be deleted
     */
    void delete(Session session);

    /**
     * Get all {@link PostitNote}s
     * @return A list of {@link PostitNote}s
     */
    List<Session> findAllSessions();

    /**
     * Get all {@link PostitNote}s in a reverse order
     * @return A reversed list of {@link PostitNote}s
     */
    List<Session> findAllSessionsReverseOrder();

    /**
     * Find a {@link PostitNote} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link PostitNote} with {@link Long id}
     */
    Session findSession(int id);

    /**
     * Find all {@link PostitNote}s with {@link String name}
     * @param name {@link String}
     * @return All {@link PostitNote}s with the {@link String name} passed
     */
    List<Session> findSessionByName(String name);
    
    /**
     * Find all {@link PostitNote}s with {@link String name}
     * @param name {@link String}
     * @return All {@link PostitNote}s with the {@link String name} passed
     */
    List<Session> findSessionByType(String type);

}
