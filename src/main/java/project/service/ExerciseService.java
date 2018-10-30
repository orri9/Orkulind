package project.service;

import project.persistence.entities.Exercise;
import project.persistence.entities.PostitNote;

import java.util.List;

public interface ExerciseService {

    /**
     * Save a {@link PostitNote}
     * @param postitNote {@link PostitNote} to be saved
     * @return {@link PostitNote} that was saved
     */
    Exercise save(Exercise exercise);

    /**
     * Delete {@link PostitNote}
     * @param postitNote {@link PostitNote} to be deleted
     */
    void delete(Exercise exercise);

    /**
     * Get all {@link PostitNote}s
     * @return A list of {@link PostitNote}s
     */
    List<Exercise> findAllExercises();

    /**
     * Get all {@link PostitNote}s in a reverse order
     * @return A reversed list of {@link PostitNote}s
     */
    List<Exercise> findAllExercisesReverseOrder();

    /**
     * Find a {@link PostitNote} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link PostitNote} with {@link Long id}
     */
    Exercise findExercise(int id);

    /**
     * Find all {@link PostitNote}s with {@link String name}
     * @param name {@link String}
     * @return All {@link PostitNote}s with the {@link String name} passed
     */
    List<Exercise> findExerciseByName(String name);
    
    /**
     * Find all {@link PostitNote}s with {@link String name}
     * @param name {@link String}
     * @return All {@link PostitNote}s with the {@link String name} passed
     */
    List<Exercise> findExerciseByType(String type);

}
