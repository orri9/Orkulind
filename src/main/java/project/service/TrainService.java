package project.service;

import java.util.List;

import project.persistence.entities.Stats;
import project.persistence.entities.Training;

public interface TrainService {

    Training save(Training training);

    void delete(Training training);

	List<Training> findTrainingsByFilter(Stats stats);

}
