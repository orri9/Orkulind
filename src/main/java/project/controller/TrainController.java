
package project.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import project.persistence.entities.Exercise;
import project.persistence.entities.Session;
import project.persistence.entities.Training;
import project.persistence.entities.TrainingList;
import project.persistence.entities.User;
import project.service.SessionService;
import project.service.TrainService;

@Controller
@SessionAttributes({"training", "trainings"})
public class TrainController  {

	// Instance Variables
	private TrainService trainService;
	private SessionService sessionService;

	// Dependency Injection
	@Autowired
    public TrainController(TrainService trainService, SessionService sessionService) {
        this.trainService = trainService;
        this.sessionService = sessionService;
    }
  
	// Handles the GET request for the URL \train and returns the corresponding view
	@RequestMapping(value = "/train", method = RequestMethod.GET)
    public String trainGetView(Model model){
		
		// Adds a training attribute to the model
		model.addAttribute("training",new Training());
		
		// Adds all user's sessions to the model 
		List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);
        
        // Returns the Train.jsp view
        return "Train";
    }
	
	// Handles the POST request for the URL \train, 
	// receives the training attribute from the model and returns the view.
	@RequestMapping(value = "/train", method = RequestMethod.POST)
	public String trainViewPost(@ModelAttribute("training") Training training, Model model){
		
		// Adds all user's sessions to the model 
		List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);
        
		TrainingList trainings = new TrainingList();
		int i = 0;
		// The training attribute now contains a session with exercises.
		// We add a Training object to the list trainings for each exercise in the training session.
		for(Exercise e: training.getSession().getExercises()) {
			trainings.add(new Training());
			trainings.get(i).setExercise(e);
			trainings.get(i).setSession(training.getSession());
			i++;
		}
		
		// Adds the trainings list to the model
		model.addAttribute("trainings", trainings);
		
		
		// Return the view
		return "Train";
	}
	
	// Handles the POST request for the URL \finishTraining,
	// receives the trainings attribute from the model and redirects to /personal.
	@RequestMapping(value = "/finishTraining", method = RequestMethod.POST)
	public String finishTrainingViewPost(@ModelAttribute("trainings") TrainingList trainings, Model model){
		
		// Saves all trainings to the database with the current date
		Date date = new Date();
		for(Training training: trainings.getTrainingList()) {
			training.setDate(date);
			trainService.save(training);
		}
		model.addAttribute("trainings", new TrainingList());
		
		// Redirect to /personal
		return "redirect:/personal";
	}
	
	@PostMapping("/api/finishTraining")
    public void finishTraining(@RequestBody List<Training> trainings) {
		for(Training training: trainings) {
			trainService.save(training);
		}	
    }
	
	// Method for binding the ${training.session} attribute to a Session object
	// that is retrieved from the database
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
