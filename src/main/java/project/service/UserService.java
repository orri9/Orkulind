
package project.service;

import project.persistence.entities.User;

public interface UserService {
	
	User storeUser(User user);
	User existUser(User user);
	User existUserAndPassword(User user);
}
