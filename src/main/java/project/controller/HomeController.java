package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.persistence.entities.User;
import project.service.UserService;

@Controller
public class HomeController {

/**
 * 	Documentation for HomeController:
	 	This controller handles the starting page Index.jps
	 	and the user login
 */
	
	private UserService userService;
	
	
	public HomeController() {
	
	}
	
	
	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * 	Usage: 	Get request on "/" 
	 * 	Before:	
	 * 	After: 	returns Index.jsp to view and logs out user if he is loge'd in
	 */
	@RequestMapping("/")
	public String HomeViewGet(Model model){
		model.addAttribute("user", new User());
		if(User.logedUser != null) {
			User.logedUser = null;
		}
		
		return "Index";
	}
	
	@RequestMapping(value = "/login/api" , method = RequestMethod.POST)
    public @ResponseBody User login(@RequestBody User user) {
    	
		User.logedUser = userService.existUserAndPassword(user);
		if(User.logedUser == null) {
			user.setError("Username or password is incorrect");
			return user; 
		}
		
		User.logedUser.setError("");
    	return User.logedUser;
    }
	
	/*
	 * Usage:	Post request on "/log"
	 * Before:
	 * After: 	from the post the user has name and password
	 * 			then it validates weather the user exist in db with correct password
	 * 			if so
	 * 				the user is logged in and "personalPage" is returned
	 * 			else
	 * 				"Index" is returned with model that contains error messages
	 */
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String exerciseViewPost(@ModelAttribute("user") User user,
	                                 Model model){
		
		User.logedUser = userService.existUserAndPassword(user);
		if(User.logedUser == null) {
			model.addAttribute("villa", "Username or password is incorrect");
			return "Index"; 
		}
		
		model.addAttribute("logedUser", "User: " + User.logedUser.getName() + " , id: " + User.logedUser.getId() );
	    return "personalPage";
	}
    
    
}
