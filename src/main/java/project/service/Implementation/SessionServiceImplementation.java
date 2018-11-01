package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.*;
import project.persistence.repositories.ExerciseRepository;
import project.persistence.repositories.SessionRepository;
import project.service.SessionService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SessionServiceImplementation implements SessionService {

    // Instance Variables
    SessionRepository repository;

    // Dependency Injection
    @Autowired
    public SessionServiceImplementation(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Session save(Session session) {
    		//prufa
    		//session.addExercise(new Exercise());
    		//
        return repository.save(session);
    }

    @Override
    public void delete(Session session) {
        repository.delete(session);
    }

    @Override
    public List<Session> findAllSessions() {
        return repository.findAll();
    }

    @Override
    public List<Session> findAllSessionsReverseOrder() {
        // Get all the Postit notes
        List<Session> sessions = repository.findAll();

        // Reverse the list
        Collections.reverse(sessions);

        return sessions;
    }

    @Override 
    public Session findSession(int id) {
        return repository.findSession(id);
    }

    @Override
    public List<Session> findSessionByName(String name) {
        return repository.findSessionByName(name);
    }

	@Override
	public List<Session> findSessionByType(String type) {
		return repository.findSessionByType(type);
	}
}
