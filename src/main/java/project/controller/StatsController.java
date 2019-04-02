
package project.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Exercise;
import project.persistence.entities.Session;
import project.persistence.entities.Stats;
import project.persistence.entities.Training;
import project.persistence.entities.User;
import project.service.ExerciseService;
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
    		
    		System.out.println(stats.getEndDate());
    		System.out.println(stats.getStartDate());
    		System.out.println(stats.getExercise().getName());
    		stats.setTrainings(trainService.findTrainingsByFilter(stats));
    		stats.calculate();
    		model.addAttribute("calcStats", stats);
    		
    		List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
    		model.addAttribute("allExercises", exercises);
    		
    		Stats newStats = new Stats();
    		model.addAttribute("stats", newStats);
    		
    		return "Stats";
    }
   
   
    @RequestMapping(value = "api/statistics", method = RequestMethod.POST)
    public  @ResponseBody List<Stats> statsViewPostApi(@RequestBody Stats stats){
    	
    	
    	List<Exercise> exercises = exerciseService.findAllUserExercises(stats.getUserId());
    	Exercise[] ex = new Exercise[exercises.size()];
    	exercises.toArray(ex);
    	
    	// List<Training> list = new ArrayList<Training>();
    	List<Stats> st = new ArrayList<Stats>();
    	
    	for(int i = 0; i < ex.length; i++) {
    		System.out.println(ex.length);
    		Stats sta = new Stats(ex[i],stats.getStartDate(),stats.getEndDate());
    		sta.setTrainings(trainService.findTrainingsByFilterApi(sta.getExercise(), stats.getStartDate(), sta.getEndDate()));
    		sta.calculate();
    		
    		if(sta.getTrainings().size() > 0) {
    			st.add(sta);		    			
    		}
    		
    	}
    	
		return st;
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
