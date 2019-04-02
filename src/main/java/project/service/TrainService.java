package project.service;

import java.util.Date;
import java.util.List;

import project.persistence.entities.Exercise;
import project.persistence.entities.Stats;
import project.persistence.entities.Training;

public interface TrainService {

    Training save(Training training);

    void delete(Training training);

	List<Training> findTrainingsByFilter(Stats stats);
	
	List<Training> findTrainingsByFilterApi(Exercise exercises , Date startDate, Date endDate);
	
	List<Training> findAll();
	
	List<Training> findAllUserTraining(int id);

}
