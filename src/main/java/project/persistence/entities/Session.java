package project.persistence.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Session")
public class Session {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	private String name;
    private String type;
    private int userID;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Exercise> exercises;
    
    @OneToMany(mappedBy="session")
    private Set<Training> trainings;

    public Session() {
    }

    public Session(int id, String name, String type, int userID, Set<Training> trainings, Set<Exercise> exercises) {
    		this.id = id;
    		this.name = name;
        this.type = type;
        this.userID = userID;
        this.exercises = exercises;
        this.trainings = trainings;
    }
    
    public void addExercise(Exercise exercise) {
    		if (exercises == null) exercises = new HashSet<Exercise>(){{ add(exercise);}};
    		else exercises.add(exercise);
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
	
	// This is for easier debug.
    @Override
    public String toString() {
        String result = String.format(
                "Session [id=%d, name='%s']%n",
                id, name);
        if (exercises != null) {
            for(Exercise exercise : exercises) {
                result += String.format(
                        "Exercise[id=%d, name='%s']%n",
                        exercise.getId(), exercise.getName());
            }
        }

        return result;
    }
    
	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

}