package project.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "Exercise") // If you want to specify a table name, you can do so here
public class Exercise {

    // Declare that this attribute is the id
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private int reps;
    private String repType;
    private String info;
    
    @ManyToMany(mappedBy = "exercises")
    private Set<Session> sessions;

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public Exercise() {
    }

    public Exercise(int id, String name, String type, int reps, String repType, String info, Set<Session> sessions) {
    		this.id = id;
    		this.name = name;
        this.type = type;
        this.reps = reps;
        this.repType = repType;
        this.info = info;
        this.sessions = sessions;
    }
    
    

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Exercise[id=%s, name=%s]",
                id, name);
    }
    
    public void addSession(Session session) {
    		if (sessions == null) sessions = new HashSet<Session>(){{ add(session);}};
		this.sessions.add(session);
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
}
