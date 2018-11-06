package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Food;
import project.service.FoodService;
@Controller
public class FoodController {

	private FoodService foodService;
    // Dependency Injection
    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String food(){
        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
        return "Index";
    }

    // To call this method, enter "localhost:8080/food" into a browser
    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public String foodCon(Model model){

        // Here we will show how to add attributes to a model and send it to the view

        // Since this small example is for food, let's create some attributes
        // that food might usually have in a system
        String name = "Kjúlli";
        String meal  = "Kjúklingur";
        String recipe = "Settu kjúklinginn í ofn þangað til hann er tilbúinn";
        String diet = "prófæði";
        String name2 = "Kjúlli2";



        // Now let's add the attributes to the model
        model.addAttribute("name",name);
        model.addAttribute("meal",meal);
        model.addAttribute("recipe",recipe);
        model.addAttribute("diet",diet);
        
        model.addAttribute("name",name2);
        model.addAttribute("meal",meal);
        model.addAttribute("recipe",recipe);
        model.addAttribute("diet",diet);
        
        // By adding attributes to the model, we can pass information from the controller
        // to the view (the .jsp file).
        // Look at the User.jsp file in /main/webapp/WEB-INF/jsp/ to see how the data is accessed
        return "Food";
    }
}
