package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public String foodViewGet(Model model){

        model.addAttribute("Food",new Food());
        
        model.addAttribute("Foods",foodService.findAllReverseOrder());

        return "Foods";
    }
   
    @RequestMapping(value = "/postfood/{name}", method = RequestMethod.GET)
    public String getFoodFromName(@PathVariable String name,
            						Model model){
 
    	model.addAttribute("Foods", foodService.findByName(name));
    	 
         model.addAttribute("Food", new Food());

         return "Foods";
    }
  
    @RequestMapping(value = "/postfood", method = RequestMethod.POST)
    public String foodViewPost(@ModelAttribute("Food") Food food,
    							Model model) {
    	foodService.save(food);

    	model.addAttribute("Foods", foodService.findAllReverseOrder());
    	
    	model.addAttribute("Food", new Food());
    	    	
    	return "Foods";
    }
}