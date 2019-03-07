package project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.persistence.entities.User;
import project.persistence.entities.Exercise;
import project.service.ExerciseService;

@Controller
public class ExerciseController {

	// Instance Variables
    private ExerciseService exerciseService;

    // Dependency Injection
    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Handles the GET request for the URL \exercises and returns the corresponding view
    @RequestMapping(value = "/exercises", method = RequestMethod.GET)
    public String createExViewGet(Model model){
    		
    		// Adds a exercise attribute to the model
        model.addAttribute("exercise",new Exercise());

        // Adds all user's exercises to the model 
        List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);

        // Returns the Exercises.jsp view
        return "Exercises";
    }
    
    //Find all user exercises
    @PostMapping("/api/exercises")
    @ResponseBody
    public List<Exercise> getExercises(@RequestBody User user) {   		
    		return exerciseService.findAllUserExercises(user.getId());
    }
    
    //Remove Exercise
    @PostMapping("/api/removeExercise")
    public void removeExercise(@RequestBody Exercise exercise) {   		
    		exercise = exerciseService.findExercise(exercise.getId());
		exerciseService.delete(exercise);
    }
    
    //Create Exercise
    @PostMapping("/api/createExercise")
    public void createExercise(@RequestBody Exercise exercise) {   		
    		exerciseService.save(exercise);
    }
    
    // Handles the POST request for the URL \removeExercise,
    // receives the exercise attribute to remove from the model and redirects to /exercises
    @RequestMapping(value = "/removeExercise", method = RequestMethod.POST)
    public String exerciseRemoveViewPost(@ModelAttribute("exercise") Exercise exercise, Model model){
    		
    		// Finds the corresponding exercise in the database and removes it
    		exercise = exerciseService.findExercise(exercise.getId());
    		exerciseService.delete(exercise);

    		// Redirects to /exercises
        return "redirect:/exercises";
    }
    
    
    // Checks if string is just whitespace or empty
    public static boolean checkString(String s) { 	
    		if(s.length() == 0) return true;
    		if(s.matches("(\\s+)")) return true;
    		return false;
    }
    
    // Handles the POST request for the URL \exercises,
    // receives the exercise attribute from the model and returns the corresponding view
    @RequestMapping(value = "/exercises", method = RequestMethod.POST)
    public String exerciseViewPost(@ModelAttribute("exercise") Exercise exercise, Model model) {
    		
    		exercise.setUserID(User.logedUser.getId());
    	
    		// Check if the input for exercise is valid
    		if(checkString(exercise.getName())) {
    			model.addAttribute("villa", "Input cant be empty");
    			return "Exercises";
    		}
    	
    		if(exerciseService.existExercise(exercise)) {
    			model.addAttribute("villa", "Name already taken");
    			return "Exercises";	
    		}
    	
    		if(checkString(exercise.getType())) {
    			model.addAttribute("villa1", "Input cant be empty");
    			return "Exercises";
    		}
    	
    		if(checkString(exercise.getRepType())) {
    			model.addAttribute("villa2", "Input cant be empty");
    			return "Exercises";
    		}
    	
    		// save the exercise to the database
    		exerciseService.save(exercise);

    		// Adds all user's exercises to the model 
    		List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);

        // Returns the Exercises.jsp view
        return "Exercises";
    }

}
