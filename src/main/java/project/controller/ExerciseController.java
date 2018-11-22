package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.persistence.entities.Exercise;
import project.service.ExerciseService;

@Controller
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/exercises", method = RequestMethod.GET)
    public String createExViewGet(Model model){

        model.addAttribute("exercise",new Exercise());

        List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);

        return "Exercises";
    }
    
    @RequestMapping(value = "/removeExercise", method = RequestMethod.POST)
    public String sessionRemoveViewPost(@ModelAttribute("exercise") Exercise exercise,
                                     Model model){
    		
        exerciseService.delete(exercise);

        return "redirect:/exercises";
    }
    
    // Notkun: user.checkString(s)
    // Fyrir: User user, String s
    // Eftir: Ath hvort að Strengur sé bara whitespace eða hvort strengur sé tómur
    public static boolean checkString(String s) {
    	
    	if(s.length() == 0) return true;
    	if(s.matches("(\\s+)")) return true;
    	return false;
    }
    
    @RequestMapping(value = "/exercises", method = RequestMethod.POST)
    public String exerciseViewPost(@ModelAttribute("exercise") Exercise exercise,
                                     Model model){
    	
    	exercise.setUserID(User.logedUser.getId());
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
    	
    	
    		exerciseService.save(exercise);

    		List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);

        return "Exercises";
    }

}
