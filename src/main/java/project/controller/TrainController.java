

package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/") // Notice here that the Request Mapping is set at the Class level
public class TrainController  {


    // Notice here that since the class has "/demo", this path is "/demo/page"
    @RequestMapping("/train")
    public String trainGetView(){
        return "Train"; // this returns a .jsp file with the path /webapp/WEB-INF/jsp/demo/demo.jsp
    }


}
