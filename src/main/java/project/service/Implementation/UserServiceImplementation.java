

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
		if(existUser(user) == null) {
			return this.repository.save(user);			
		}
		else {
			return null;
		}
	}

	@Override
	public boolean validateName(User user) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean validatePassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User existUser(User user) {
		List<User> users = this.repository.findAll();
		for (User use : users) {
	        if (use.getName().equals(user.getName())) {
	            return use;
	        }
	    }
		return null;
	}
    
}
