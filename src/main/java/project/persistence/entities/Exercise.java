package project.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Exercise")
public class Exercise {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
    private String name;
    private String type;
    private int reps;
    private String repType;
    private String info;
    private int userID;
    
    @ManyToMany(mappedBy = "exercises")
    private Set<Session> sessions;
    
    @OneToMany(mappedBy="exercise", cascade = CascadeType.REMOVE)
    private Set<Training> trainings;

    public Exercise() {
    }

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
    
    public void addSession(Session session) {
    		if (sessions == null) sessions = new HashSet<Session>(){{ add(session);}};
		this.sessions.add(session);
    }
    
    @PreRemove
    public void removeExerciseFromSessions() {
        for (Session s : sessions) {
            s.getExercises().remove(this);
        }
    }

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
