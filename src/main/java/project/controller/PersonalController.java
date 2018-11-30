
package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	Documentation for PersonalController:
	 	This controller handles the personalPage
 */

@Controller
@RequestMapping("/") 
public class PersonalController  {

	public PersonalController() {
		
	}
	
	/*
	 * 	Usage: 	Get request on "/personal" 
	 * 	Before:	
	 * 	After: 	returns personalPage.jsp to view
	 */
    @RequestMapping("/personal")
    public String demoPage(Model model){
        	return "personalPage"; 
    }


}
