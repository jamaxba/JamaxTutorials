package ba.maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import ba.maven.model.UserModel;
import ba.maven.service.UserService;
import ba.maven.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/register")
public class RegisterContoller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		UserModel userForm = new UserModel();
		model.put("userForm", userForm);
		
		return "registration";
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") UserModel userForm, BindingResult bindingResult, Map model ){
		// IMPLEMENT REGISTRATION LOGIC
		userValidator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()){
			return "registration";
		}
		
		userService.save(userForm);
		
		System.out.println("Implement Registration Logic");
		return "registrationSuccess";
	}

}
