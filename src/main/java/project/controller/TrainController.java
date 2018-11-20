

package project.controller;

import java.beans.PropertyEditorSupport;
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
import project.persistence.entities.PostitNote;
import project.persistence.entities.Session;
import project.persistence.entities.Training;
import project.service.ExerciseService;
import project.service.SessionService;
import project.service.TrainService;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/") // Notice here that the Request Mapping is set at the Class level
@SessionAttributes("training")
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
		

        model.addAttribute("allSessions", sessionService.findAllSessions());
        return "Train"; // this returns a .jsp file with the path /webapp/WEB-INF/jsp/demo/demo.jsp
    }
	
	@RequestMapping(value = "/train", method = RequestMethod.POST)
	public String trainViewPost(@ModelAttribute("training") Training training,
            Model model){
		
		model.addAttribute("allSessions", sessionService.findAllSessions());
	
		model.addAttribute("training", training);
		
		
		// Return the view
		return "Train";
	}
	
	@RequestMapping(value = "/finishTraining", method = RequestMethod.POST)
	public String finishTrainingViewPost(@ModelAttribute("training") Training training,
            Model model){
		
		training.setDate(new Date());
		sessionService.save(training.getSession());
		trainService.save(training);
		
		
		// Return the view
		return "personalPage";
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
