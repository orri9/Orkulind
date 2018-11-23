package project.controller;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Server;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import project.persistence.entities.Exercise;
import project.persistence.entities.Session;
import project.persistence.entities.Stats;
import project.persistence.entities.Training;
import project.persistence.entities.TrainingList;
import project.persistence.entities.User;
import project.service.ExerciseService;
import project.service.SessionService;
import project.service.TrainService;

@Controller
public class StatsController {

    private TrainService trainService;
    private ExerciseService exerciseService;

    @Autowired
    public StatsController(TrainService trainService, ExerciseService exerciseService) {
        this.trainService = trainService;
        this.exerciseService = exerciseService;
    }
    
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statsViewGet(Model model){
    	
    		List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
    		model.addAttribute("allExercises", exercises);
    		
    		Stats stats = new Stats();
    		model.addAttribute("stats", stats);
    		return "Stats";
    }
    
    @RequestMapping(value = "/statistics", method = RequestMethod.POST)
    public String statsViewPost(@ModelAttribute("stats") Stats stats, Model model){
    		
    		stats.setTrainings(trainService.findTrainingsByFilter(stats));
    		stats.calculate();
    		model.addAttribute("calcStats", stats);
    		
    		List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
    		model.addAttribute("allExercises", exercises);
    		
    		Stats newStats = new Stats();
    		model.addAttribute("stats", newStats);
    		
    		return "Stats";
    }
    
    @InitBinder     
    public void initBinder(WebDataBinder binder){
    		binder.registerCustomEditor(Exercise.class, "exercise", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Exercise type = exerciseService.findExercise(Integer.parseInt(text));
                setValue(type);
            }
        });  
    }

    
}
