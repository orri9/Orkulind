package project.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Exercise") // Table for the database
public class Exercise {

	// Private variables
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
    private String name;
    private String type;
    private int reps;
    private String repType;
    private String info;
    private int userID;
    
    // Many to many relationship with sessions
    // An exercise contains a set of sessions
    @ManyToMany(mappedBy = "exercises")
    private Set<Session> sessions;
    
    // One to many relationship with  trainings
    // An exercise contains a set of trainings
    @OneToMany(mappedBy="exercise", cascade = CascadeType.REMOVE)
    private Set<Training> trainings;

    // Empty constructor
    public Exercise() {
    }

    // Constructor
    public Exercise(int id, String name, String type, int reps, String repType, String info, int userID, Set<Session> sessions) {
    		this.id = id;
    		this.name = name;
        this.type = type;
        this.reps = reps;
        this.repType = repType;
        this.info = info;
        this.userID = userID;
        this.sessions = sessions;
    }
    
    // Add session to the set of sessions
    public void addSession(Session session) {
    		if (sessions == null) sessions = new HashSet<Session>(){{ add(session);}};
		this.sessions.add(session);
    }
    
    // Before removing an exercise from the database it
    // needs to be removed from all sessions it belongs to
    @PreRemove
    public void removeExerciseFromSessions() {
        for (Session s : sessions) {
            s.getExercises().remove(this);
        }
    }
    
    // Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public String getRepType() {
		return repType;
	}

	public void setRepType(String repType) {
		this.repType = repType;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Override
    public String toString() {
        return String.format(
                "%s",
                id);
    }
}
