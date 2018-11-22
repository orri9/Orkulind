package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Exercise;
import project.persistence.entities.PostitNote;
import project.persistence.entities.User;
import project.persistence.repositories.ExerciseRepository;
import project.persistence.repositories.PostitNoteRepository;
import project.service.ExerciseService;
import project.service.PostitNoteService;

import java.util.Collections;
import java.util.List;

@Service
public class ExerciseServiceImplementation implements ExerciseService {

    ExerciseRepository repository;

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
        List<Exercise> exercises = repository.findAll();

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

	@Override
	public List<Exercise> findAllUserExercises(int id) {
		return repository.findAllUserExercises(id);
	}

	@Override
	public boolean existExercise(Exercise exercise) {
		List<Exercise> exercises = this.repository.findAll();
		for (Exercise ex : exercises) {
	        if (ex.getName().equals(exercise.getName())) {
	            return true;
	        }
	    }
		return false;
	}
	
}
