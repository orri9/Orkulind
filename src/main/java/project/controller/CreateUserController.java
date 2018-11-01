
package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Exercise;
import project.persistence.entities.User;
import project.service.UserService;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/") // Notice here that the Request Mapping is set at the Class level
public class CreateUserController  {
	 
	private UserService userService;
	
	
	public CreateUserController() {
	}
	
	
	@Autowired
	public CreateUserController(UserService userService) {
		this.userService = userService;
	}
	
    // Notice here that since the class has "/demo", this path is "/demo/page"
    @RequestMapping("/createUser")
    public String getCreateUserView(Model model){
    	model.addAttribute("storeUser", new User());
        return "CreateUser"; // this returns a .jsp file with the path /webapp/WEB-INF/jsp/demo/demo.jsp
    }
    
    @RequestMapping(value = "/storeUser", method = RequestMethod.POST)
    public String createUserViewPost(@ModelAttribute("storeUser") User user,
                                     Model model){

        model.addAttribute("storeUser", new User());
        userService.storeUser(user);
        return "CreateUser";
    }



}