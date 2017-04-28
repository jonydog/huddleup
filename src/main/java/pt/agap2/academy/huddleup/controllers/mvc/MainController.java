package pt.agap2.academy.huddleup.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/huddleup")
	public ModelAndView welcome(){
		
		return new ModelAndView("index.html");
	}
	
	
	
}
