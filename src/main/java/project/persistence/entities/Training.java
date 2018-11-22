package project.persistence.entities;

import java.util.Date;


import javax.persistence.*;


@Entity
@Table(name = "Training")
public class Training {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="session_id", nullable=false)
	private Session session;
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="exercise_id", nullable=false)
	private Exercise exercise;
	private int reps;

	
    public Training() {
    }

    public Training(int id, Session session, Date date, Exercise exercise, int reps) {
    		this.id = id;
    		this.session = session;
    		this.date = date;
    		this.exercise = exercise;
    		this.reps = reps;
    }
    
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
