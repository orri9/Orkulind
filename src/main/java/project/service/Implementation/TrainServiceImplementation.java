package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.*;
import project.persistence.repositories.ExerciseRepository;
import project.persistence.repositories.TrainRepository;
import project.service.TrainService;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrainServiceImplementation implements TrainService {

    TrainRepository repository;

    @Autowired
    public TrainServiceImplementation(TrainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Training save(Training training) {
        return repository.save(training);
    }

    @Override
    public void delete(Training training) {
        repository.delete(training);
    }

	@Override
	public List<Training> findTrainingsByFilter(Stats stats) {
		return repository.findTrainingsByFilter(stats.getExercise(), stats.getStartDate(), stats.getEndDate());
	}

	@Override
	public List<Training> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Training> findAllUserTraining(int id) {
		return repository.findAll();
	}

	@Override
	public List<Training> findTrainingsByFilterApi(Exercise exercise , Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		
		return repository.findTrainingsByFilterApi(exercise, startDate, endDate);
	}
}
