package project.persistence.entities;

import java.util.Date;


import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Training") // Table in database
public class Training {

	// Private variables
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	// Many to one relationship with session
	// training contains a single session
	@ManyToOne
    @JoinColumn(name="session_id", nullable=false)
	private Session session;
	
	// Many to one relationship with exercise
	// training contains a single exercise
	@ManyToOne
    @JoinColumn(name="exercise_id", nullable=false)
	private Exercise exercise;
	
	private Date date;
	private int reps;

	// Empty Constructor
    public Training() {
    }

    // Constructor
    public Training(int id, Session session, Date date, Exercise exercise, int reps) {
    		this.id = id;
    		this.session = session;
    		this.date = date;
    		this.exercise = exercise;
    		this.reps = reps;
    }
    
    
    // Getters & Setters
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

}
