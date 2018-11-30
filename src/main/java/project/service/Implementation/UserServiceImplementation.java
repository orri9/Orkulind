package project.service.Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
	
	UserRepository repository;
    
	@Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }
	
    // Usage:  userService.storeUser(user)
	// Before: User user, UserService userService
	// After:  If user exist in database don't store him and return null
	// 		   else store him and return user
	public User storeUser(User user) {
		if(existUser(user) == null) {
			return this.repository.save(user);			
		}
		else {
			return null;
		}
	}
	
	// Usage:	userService.existUserAndPassword(user)
	// Before:	User user, UserService userService
	// After: 	return null if user and password dose not exist
	//			else return user
	@Override
	public User existUserAndPassword(User user) {
		List<User> users = this.repository.findAll();
		for (User use : users) {
	        if (use.getName().equals(user.getName()) && use.getPassword().equals(user.getPassword())) {
	            return use;
	        }
	    }
		return null;
	}
	
	// Usage:	userService.existUser(user)
	// Before:	User user, UserService userService
	// After: 	return null if user dose not exist
	//			else return user
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
