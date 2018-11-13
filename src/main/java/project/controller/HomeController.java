package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Exercise;
import project.persistence.entities.User;
import project.service.UserService;

@Controller
public class HomeController {

	
private UserService userService;
	
	
	public HomeController() {
	
	}
	
	
	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/")
	public String HomeViewGet(Model model){
		model.addAttribute("user", new User());
		return "Index";
	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String exerciseViewPost(@ModelAttribute("user") User user,
	                                 Model model){
		
		User.logedUser = userService.existUser(user);
		if(User.logedUser == null) {
			model.addAttribute("villa", "Username or password is incorrect");
			return "Index"; 
		} 
		
		model.addAttribute("logedUser", "User: " + User.logedUser.getName() + " , id: " + User.logedUser.getId() );
	    return "personalPage";
	}
    
    
}
