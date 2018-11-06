package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Session;
import project.service.SessionService;

@Controller
public class SessionController {

    // Instance Variables
    private SessionService sessionService;

    // Dependency Injection
    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Method that returns the correct view for the URL /postit
    // This handles the GET request for this URL
    // Notice the `method = RequestMethod.GET` part
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public String createExViewGet(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("session",new Session());

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
         model.addAttribute("sessions", sessionService.findAllSessionsReverseOrder());

        // Return the view
        return "Sessions";
    }

    // Method that receives the POST request on the URL /postit
    // and receives the ModelAttribute("postitNote")
    // That attribute is the attribute that is mapped to the form, so here
    // we can save the postit note because we get the data that was entered
    // into the form.
    // Notice the `method = RequestMethod.POST` part
    @RequestMapping(value = "/ses", method = RequestMethod.POST)
    public String sessionViewPost(@ModelAttribute("session") Session session,
                                     Model model){

        // Save the Postit Note that we received from the form
        sessionService.save(session);

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("sessions", sessionService.findAllSessionsReverseOrder());

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("session", new Session());

        // Return the view
        return "Sessions";
    }

    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/ses/{name}", method = RequestMethod.GET)
    public String sessionGetSessionsFromName(@PathVariable String name,
                                             Model model){

        // Get all Postit Notes with this name and add them to the model
        model.addAttribute("sessions", sessionService.findSessionByName(name));

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("session", new Session());

        // Return the view
        return "Sessions";
    }
}
