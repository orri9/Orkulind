package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User save(User user);
	
}
