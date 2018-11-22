package project.service;

import project.persistence.entities.Exercise;
import project.persistence.entities.PostitNote;

import java.util.List;

public interface ExerciseService {

    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAllExercises();

    List<Exercise> findAllExercisesReverseOrder();

    Exercise findExercise(int id);

    List<Exercise> findExerciseByName(String name);
    
    List<Exercise> findExerciseByType(String type);
    
    boolean existExercise(Exercise exercise);

	List<Exercise> findAllUserExercises(int id);



}
