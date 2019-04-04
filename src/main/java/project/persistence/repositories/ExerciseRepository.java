package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Exercise;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAll();

    @Query(value = "SELECT p FROM Exercise p WHERE p.id = ?1")
    Exercise findOne(int id);
    
    List<Exercise> findByName(String name);
    
    List<Exercise> findByType(String type);

    @Query(value = "SELECT p FROM Exercise p WHERE p.userID = ?1")
	List<Exercise> findAllUserExercises(int user);
}
