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
import project.persistence.entities.User;
import project.service.ExerciseService;
import project.service.SessionService;

@Controller
public class SessionController {

    private SessionService sessionService;
    private ExerciseService exerciseService;

    @Autowired
    public SessionController(SessionService sessionService, ExerciseService exerciseService) {
        this.sessionService = sessionService;
        this.exerciseService = exerciseService;
    }
    
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public String createSessionViewGet(Model model){

        model.addAttribute("session",new Session());
        
        List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);
        
        List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);

        return "Sessions";
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public String sessionViewPost(@ModelAttribute("session") Session session,
                                     Model model){
    		
    		session.setUserID(User.logedUser.getId());
        sessionService.save(session);
        
        List<Exercise> exercises = exerciseService.findAllUserExercises(User.logedUser.getId());
        model.addAttribute("allExercises", exercises);
        
        List<Session> sessions = sessionService.findAllUserSessions(User.logedUser.getId());
        model.addAttribute("allSessions", sessions);

        model.addAttribute("session", new Session());

        return "Sessions";
    }
    
    @RequestMapping(value = "/removeSession", method = RequestMethod.POST)
    public String sessionRemoveViewPost(@ModelAttribute("session") Session session,
                                     Model model){
    		
    		session = sessionService.findSession(session.getId());
        sessionService.delete(session);

        return "redirect:/sessions";
    }

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
