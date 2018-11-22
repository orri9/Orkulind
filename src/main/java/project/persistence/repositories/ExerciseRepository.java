package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Exercise;
import project.persistence.entities.PostitNote;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAll();

    @Query(value = "SELECT p FROM Exercise p WHERE p.id = ?1")
    Exercise findExercise(int id);

    @Query(value = "SELECT p FROM Exercise p WHERE p.name = ?1")
    List<Exercise> findExerciseByName(String name);
    
    @Query(value = "SELECT p FROM Exercise p WHERE p.type = ?1")
    List<Exercise> findExerciseByType(String type);

    @Query(value = "SELECT p FROM Exercise p WHERE p.userID = ?1 OR p.userID = 0")
	List<Exercise> findAllUserExercises(int user);
}
