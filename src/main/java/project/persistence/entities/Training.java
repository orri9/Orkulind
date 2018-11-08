package project.persistence.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Training")
public class Training {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	@ManyToOne
    @JoinColumn(name="session_id", nullable=false)
	private Session session;
	private Date date;

    public Training() {
    }

    public Training(int id, Session session, Date date) {
    		this.id = id;
    		this.session = session;
    		this.date = date;
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

}
