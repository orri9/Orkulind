

package project.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import project.persistence.entities.Exercise;
import project.persistence.entities.Session;
import project.persistence.entities.Training;
import project.persistence.entities.TrainingList;
import project.persistence.entities.User;
import project.service.ExerciseService;
import project.service.SessionService;
import project.service.TrainService;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/") // Notice here that the Request Mapping is set at the Class level
@SessionAttributes({"training", "trainings"})
public class TrainController  {

	private TrainService trainService;
	private SessionService sessionService;

	@Autowired
    public TrainController(TrainService trainService, SessionService sessionService) {
        this.trainService = trainService;
        this.sessionService = sessionService;
    }
  
	@RequestMapping(value = "/train", method = RequestMethod.GET)
    public String trainGetView(Model model){

		model.addAttribute("training",new Training());
		
		List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);
        return "Train"; // this returns a .jsp file with the path /webapp/WEB-INF/jsp/demo/demo.jsp
    }
	
	@RequestMapping(value = "/train", method = RequestMethod.POST)
	public String trainViewPost(@ModelAttribute("training") Training training,
            Model model){
		
		
		List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);
		
		TrainingList trainings = new TrainingList();
		int i = 0;
		for(Exercise e: training.getSession().getExercises()) {
			trainings.add(new Training());
			trainings.get(i).setExercise(e);
			trainings.get(i).setSession(training.getSession());
			i++;
		}
		
		model.addAttribute("trainings", trainings);
		
		
		// Return the view
		return "Train";
	}
	
	@RequestMapping(value = "/finishTraining", method = RequestMethod.POST)
	public String finishTrainingViewPost(@ModelAttribute("trainings") TrainingList trainings,
            Model model){
		
		Date date = new Date();
		for(Training training: trainings.getTrainingList()) {
			training.setDate(date);
			trainService.save(training);
		}
		
		
		// Return the view
		return "redirect:/personal";
	}
	
	@InitBinder     
    public void initBinder(WebDataBinder binder){
    		binder.registerCustomEditor(Session.class, "session", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Session type = sessionService.findSession(Integer.parseInt(text));
                setValue(type);
            }
        });  
    }
	


}
