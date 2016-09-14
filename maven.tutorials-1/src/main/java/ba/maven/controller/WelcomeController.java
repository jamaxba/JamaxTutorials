package ba.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public ModelAndView welcomeMessage(
		@RequestParam(value = "name", required = false) String name) {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("name", name);
		return view;
	}

}
