package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Training;

import java.util.List;

public interface TrainRepository extends JpaRepository<Training, Long> {

    Training save(Training training);

    void delete(Training training);

    List<Training> findAll();

    @Query(value = "SELECT p FROM Training p WHERE p.id = ?1")
    Training findTraining(int id); 
    
}
