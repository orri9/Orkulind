
package project.service;

import project.persistence.entities.User;

import java.util.List;

public interface UserService {
	
	User storeUser(User user);
	boolean validateName(User user);
	boolean validatePassword(User user);
	User existUser(User user);
}
