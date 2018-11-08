package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/food")
    public String getFoodView(Model model){
    	model.addAttribute("storeFood", new Food());
        return "Food";
    }
    
    @RequestMapping(value = "/food", method = RequestMethod.POST)
    public String foodViewPost(@ModelAttribute("food") Food food,
    							Model model) {
    	foodService.save(food);
    	
    	model.addAttribute("food", new Food());
    	
    	model.addAttribute("food", foodService.findAllReverseOrder());
    	
    	return "food/Food";
    }
}