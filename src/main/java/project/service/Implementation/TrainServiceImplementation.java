package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.*;
import project.persistence.repositories.ExerciseRepository;
import project.persistence.repositories.TrainRepository;
import project.service.TrainService;

import java.util.Collections;
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

    /*
    @Override
    public List<Training> findAllTrainings() {
        return repository.findAll();
    }

    @Override
    public List<Training> findAllTrainingsReverseOrder() {

        List<Training> trainings = repository.findAll();

        Collections.reverse(trainings);

        return trainings;
    }

    @Override 
    public Training findTraining(int id) {
        return repository.findTraining(id);
    }
    */
}
