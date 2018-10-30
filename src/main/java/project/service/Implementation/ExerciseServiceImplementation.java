package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Exercise;
import project.persistence.entities.PostitNote;
import project.persistence.repositories.ExerciseRepository;
import project.persistence.repositories.PostitNoteRepository;
import project.service.ExerciseService;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service
public class ExerciseServiceImplementation implements ExerciseService {

    // Instance Variables
    ExerciseRepository repository;

    // Dependency Injection
    @Autowired
    public ExerciseServiceImplementation(ExerciseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Exercise save(Exercise exercise) {
        return repository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        repository.delete(exercise);
    }

    @Override
    public List<Exercise> findAllExercises() {
        return repository.findAll();
    }

    @Override
    public List<Exercise> findAllExercisesReverseOrder() {
        // Get all the Postit notes
        List<Exercise> exercises = repository.findAll();

        // Reverse the list
        Collections.reverse(exercises);

        return exercises;
    }

    @Override 
    public Exercise findExercise(int id) {
        return repository.findExercise(id);
    }

    @Override
    public List<Exercise> findExerciseByName(String name) {
        return repository.findExerciseByName(name);
    }

	@Override
	public List<Exercise> findExerciseByType(String type) {
		return repository.findExerciseByType(type);
	}
}
