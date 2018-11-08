package project.persistence.entities;

import javax.persistence.*;


@Entity
@Table(name = "username") // If you want to specify a table name, you can do so here
public class User {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    public static User logedUser;
    
    public User() {
    	
    }
    
    public User(String name, String password) {
    	this.name = name;
    	this.password = password;
    }
    
    
    @Override
    public String toString() {
        return String.format(
                "Postit Note[name=%s, note=%s]",
                id, name);
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPassword() {
    	return password;
    }
}
