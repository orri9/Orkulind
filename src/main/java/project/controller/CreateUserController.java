
package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.User;
import project.service.UserService;

/**
 * 	Documentation for CreteUserController
 	This controller handles user creation
 */


@Controller
@RequestMapping("/") 
public class CreateUserController  {
	
	private UserService userService;
	
	
	public CreateUserController() {
	}
	
	
	@Autowired
	public CreateUserController(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * 	Usage: Get request on "/createUser" 
	 * 	Before:
	 * 	After: returns the createUser.jsp view 
	 */
    @RequestMapping("/createUser")
    public String getCreateUserView(Model model){
    	model.addAttribute("storeUser", new User());
        return "CreateUser"; 
    }
    
    
	/*
	 * Usage: 	Post request on "/storeUser"
	 * Before: 	validates the User from the form
	 * 			checks both user name and password for these conditions.
	 *			User can't already exist in the database.
	 *			string can't contain white space and can't be empty.
	 *			
	 * After: 	if the validation stands then new user is created 
	 *				returns the createUser.jsp view with a model that contains a success 
	 *				message for user creation
	 *			else
	 *				there is a model that is pass't to the view with error messages
	 *		
	 */
    @RequestMapping(value = "/storeUser", method = RequestMethod.POST)
    public String createUserViewPost(@ModelAttribute("storeUser") User user,
                                     Model model){
    	
    	if(user.getPassword().matches("(.*\\s+.*)*") || user.getPassword().matches("\\s+.*\\s+")) {
    		model.addAttribute("villa", "Password cant include whitespace");
    		return "CreateUser";
    	}
    	
    	if(user.getPassword().length() == 0) {
    		model.addAttribute("villa", "Password must have length larger then zero");
    		return "CreateUser";
    	}
    	
    	if(user.getName().length() == 0) {
    		model.addAttribute("villa", "Name must have length larger then zero");
    		return "CreateUser";
    	}
    	
    	if(userService.storeUser(user) == null) {
        	if(user.getName().matches(".*\\s+.*")) {
        		model.addAttribute("villa", "Name cant include whitespace");
        		return "CreateUser";
        	}
        	model.addAttribute("villa", "User already exist");
        	return "CreateUser";
        }
        
    	model.addAttribute("creatUser", "User has been created");

        return "CreateUser";
    }



}