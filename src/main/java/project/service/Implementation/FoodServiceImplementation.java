package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Food;
import project.persistence.repositories.FoodRepository;
import project.service.FoodService;

import java.util.Collections;
import java.util.List;

@Service
public class FoodServiceImplementation implements FoodService {

    // Instance Variables
    FoodRepository repository;

    // Dependency Injection
    @Autowired
    public FoodServiceImplementation(FoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public Food save(Food food) {
        return repository.save(food);
    }

    @Override
    public void delete(Food food) {
        repository.delete(food);
    }

    @Override
    public List<Food> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Food> findAllReverseOrder() {
        // Get all the Food
        List<Food> food = repository.findAll();

        // Reverse the list
        Collections.reverse(food);

        return food;
    }

    @Override 
    public Food findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Food> findByName(String name) {
        return repository.findByName(name);
    }
}
