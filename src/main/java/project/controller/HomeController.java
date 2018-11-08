package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Exercise;
import project.persistence.entities.User;

@Controller
public class HomeController {

	
	@Autowired
	public HomeController() {
		
	}

	 @RequestMapping("/")
	    public String HomeViewGet(Model model){
	    	model.addAttribute("user", new User());
	    	return "Index";
	 	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String exerciseViewPost(@ModelAttribute("user") User user,
	                                 Model model){
		
		User.logedUser = user;
		User.logedUser.setId(1);
		model.addAttribute("logedUser", "User: " + User.logedUser.getName() + " , id: " + User.logedUser.getId() );
	    return "personalPage";
	}
    
    
}
