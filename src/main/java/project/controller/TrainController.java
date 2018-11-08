

package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
