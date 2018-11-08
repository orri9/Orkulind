package project.service;

import java.util.List;

import project.persistence.entities.PostitNote;
import project.persistence.entities.Training;

public interface TrainService {

    Training save(Training training);

    void delete(Training training);

/*    List<Training> findAllTrainings();

    List<Training> findAllTrainingsReverseOrder();

    Training findTraining(int id);

*/
}
