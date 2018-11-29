package project.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Session") // Table for the database
public class Session {

	// Private variables
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	private String name;
    private String type;
    private int userID;
    
    // Many to many relationship with exercises
    // A session contains a set of exercises
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable
    private Set<Exercise> exercises;
    
    // One to many relationship with  trainings
    // A session contains a set of trainings
    @OneToMany(mappedBy="session", cascade = CascadeType.REMOVE)
    private Set<Training> trainings;

    // Empty Constructor
    public Session() {
    }

    // Constructor
    public Session(int id, String name, String type, int userID, Set<Training> trainings, Set<Exercise> exercises) {
    		this.id = id;
    		this.name = name;
        this.type = type;
        this.userID = userID;
        this.exercises = exercises;
        this.trainings = trainings;
    }
    
    // Before removing an session from the database it
    // needs to be removed from all exercises it belongs to
    @PreRemove
    public void removeSessionFromExercises() {
        for (Exercise e : exercises) {
            e.getSessions().remove(this);
        }
    }
    
    // Add exercise
    public void addExercise(Exercise exercise) {
    		if (exercises == null) exercises = new HashSet<Exercise>(){{ add(exercise);}};
    		else exercises.add(exercise);
    }

    // Getters & setters
    
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

	
	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
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
