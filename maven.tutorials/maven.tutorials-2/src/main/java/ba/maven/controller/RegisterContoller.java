package ba.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import ba.maven.model.UserModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/register")
public class RegisterContoller {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		UserModel userForm = new UserModel();
		model.put("userForm", userForm);
		
		List<String> professionList = new ArrayList<>();
		professionList.add("Developer");
		professionList.add("Designer");
		professionList.add("IT Manager");
		model.put("professionList", professionList);
		
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") UserModel user, Map<String, Object> model ){
		// IMPLEMENT REGISTRATION LOGIC
		System.out.println("Implement Registration Logic");
		return "registrationSuccess";
	}

}
