package project.persistence.entities;

import javax.persistence.*;

/**
 * The class for the Food Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "Food") // If you want to specify a table name, you can do so here
public class Food {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    	private Long id;
    
    private String name;
    private String meal;
    @Column(name = "recipe", length = 5000)
    	private String recipe;
    private String diet;

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our for
    public Food() {
    }

    public Food(String name, String meal, String recipe, String diet) {
        this.name = name;
        this.meal = meal;
        this.recipe = recipe;
        this.diet = diet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }
    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Food[name=%s, meal=%s, recipe=%s, diet=%s]",
                name,meal,recipe,diet);
    }
}
