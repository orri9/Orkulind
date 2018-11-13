
package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.persistence.entities.User;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/") // Notice here that the Request Mapping is set at the Class level
public class PersonalController  {

	public PersonalController() {
		
	}
	
    // Notice here that since the class has "/demo", this path is "/demo/page"
    @RequestMapping("/personal")
    public String demoPage(Model model){
    	// System.out.println(User.logedUser.getName());

    	return "personalPage"; // this returns a .jsp file with the path /webapp/WEB-INF/jsp/demo/demo.jsp
    }


}
