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
@Table(name = "Session") // If you want to specify a table name, you can do so here
public class Session {

    // Declare that this attribute is the id
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Exercise> exercises;

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public Session() {
    }

    public Session(int id, String name, String type, Set<Exercise> exercises) {
    		this.id = id;
    		this.name = name;
        this.type = type;
        this.exercises = exercises;
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


}
