

package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
	
	UserRepository repository;
    
	@Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }
    
	public User storeUser(User user) {
		return this.repository.save(user);
	}
    
}
