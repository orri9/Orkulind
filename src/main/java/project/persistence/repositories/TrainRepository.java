package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Exercise;
import project.persistence.entities.Stats;
import project.persistence.entities.Training;

import java.util.Date;
import java.util.List;

public interface TrainRepository extends JpaRepository<Training, Long> {

    Training save(Training training);

    void delete(Training training);

    List<Training> findAll();

    @Query(value = "SELECT p FROM Training p WHERE p.id = ?1")
    Training findOne(int id);

    @Query(value = "SELECT p FROM Training p WHERE p.exercise = ?1 AND p.date BETWEEN ?2 AND ?3")
    List<Training> findTrainingsByFilter(Exercise exercise, Date startDate, Date endDate); 
    
}
