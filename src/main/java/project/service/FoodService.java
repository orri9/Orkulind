package project.service;

import project.persistence.entities.Food;

import java.util.List;

public interface FoodService {

    /**
     * Save a {@link Food}
     * @param Food {@link Food} to be saved
     * @return {@link Food} that was saved
     */
    Food save(Food food);

    /**
     * Delete {@link Food}
     * @param food {@link Food} to be deleted
     */
    void delete(Food food);

    /**
     * Get all {@link Food}s
     * @return A list of {@link Food}s
     */
    List<Food> findAll();

    /**
     * Get all {@link Food}s in a reverse order
     * @return A reversed list of {@link Food}s
     */
    List<Food> findAllReverseOrder();
    
    /**
     * Find a {@link Food} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Food} with {@link Long id}
     */
    Food findOne(Long id);

    /**
     * Find all {@link Food}s with {@link String name}
     * @param name {@link String}
     * @return All {@link Food}s with the {@link String name} passed
     */
    List<Food> findByName(String name);

}
