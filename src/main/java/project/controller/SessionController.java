package project.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.persistence.entities.Exercise;
import project.persistence.entities.Session;
import project.persistence.entities.User;
import project.service.ExerciseService;
import project.service.SessionService;

@Controller
public class SessionController {

	// Instance Variables
    private SessionService sessionService;
    private ExerciseService exerciseService;

    // Dependency Injection
    @Autowired
    public SessionController(SessionService sessionService, ExerciseService exerciseService) {
        this.sessionService = sessionService;
        this.exerciseService = exerciseService;
    }
    
    // Handles the GET request for the URL \sessions and returns the corresponding view
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public String createSessionViewGet(Model model){
    	
    		// Adds a session attribute to the model
        model.addAttribute("session",new Session());
        
        // Adds all user's exercises to the model 
        List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);
        
        // Adds all user's sessions to the model 
        List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);

        // Returns the Session.jsp view
        return "Sessions";
    }
    
    //Find all user sessions
    @PostMapping("/api/sessions")
    @ResponseBody
    public List<Session> getSessions(@RequestBody User user) {
    		return sessionService.findAllUserSessions(user.getId());
    }
    
    //Remove Session
    @PostMapping("/api/removeSession")
    public void removeSession(@RequestBody Session session) {   		
    		session = sessionService.findSession(session.getId());
		sessionService.delete(session);
    }
    
    //Create Session
    @PostMapping("/api/createSession")
    public void createSession(@RequestBody Session session) {
    		sessionService.save(session);
    }

    // Handles the POST request for the URL \sessions,
    // receives the session attribute from the model and returns the corresponding view
    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public String sessionViewPost(@ModelAttribute("session") Session session,Model model){
    		
    		// Assigns userID to the session and saves to the database
    		session.setUserID(User.logedUser.getId());
        sessionService.save(session);
        
        // Adds all user's exercises to the model 
        List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);
        
        // Adds all user's sessions to the model
        List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);

        // Adds a session attribute to the model
        model.addAttribute("session", new Session());
        
        // Returns the Sessions.jsp view
        return "Sessions";
    }
    
    // Handles the POST request for the URL \removeSession,
    // receives the session attribute to remove from the model and redirects to /sessions
    @RequestMapping(value = "/removeSession", method = RequestMethod.POST)
    public String sessionRemoveViewPost(@ModelAttribute("session") Session session, Model model){
    		
    		// Finds the corresponding session in the database and removes it
    		session = sessionService.findSession(session.getId());
        sessionService.delete(session);

        // Redirects to /sessions
        return "redirect:/sessions";
    }

    // Method for binding the ${session.exercises} attributes to Exercise objects
 	// that are retrieved from the database
    @InitBinder     
    public void initBinder(WebDataBinder binder){
    		binder.registerCustomEditor(Exercise.class, "exercises", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Exercise type = exerciseService.findExercise(Integer.parseInt(text));
                setValue(type);
            }
        });  
    }
    
}
