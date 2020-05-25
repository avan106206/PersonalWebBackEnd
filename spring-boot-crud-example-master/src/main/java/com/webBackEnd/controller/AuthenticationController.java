package com.webBackEnd.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webBackEnd.entity.User;
import com.webBackEnd.service.UserServiceInterfaceImplementation;

@Controller
//@RestController
//@RequestMapping(value = {"/authentication"})
public class AuthenticationController {
	@Autowired
	UserServiceInterfaceImplementation userServiceInterfaceImplementation;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user); // add model object named user
		modelAndView.setViewName("register"); // resources/templates/register.html
		return modelAndView; //return both view and model
	}
	
	@PostMapping("register") // when the form with action: post submitted, route to here
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView(); //modelAndView is the function variable
		//Check the validation Error
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the error"); // add the key-value pair to the modelAndView in this function
			modelMap.addAttribute("bindingResult", bindingResult);// then we add the bindResult, so that we can add the corresponding message
		}
		//if the result is no error, call the service to save the user registration form.
		else if(userServiceInterfaceImplementation.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "user already exists");
		}else {
			userServiceInterfaceImplementation.saveUser(user);
			modelAndView.addObject("successMessage", "User is registered successfully");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		
		return modelAndView;
		
	}
	
	/*Old way, the result is exactly same with above, but using ModelAndView as the object can return view and model at the same method
	@GetMapping("/register")
	public String RegisterController(Model model){
		model.addAttribute("user", new User()); // add model object named user
		return "register"; // return the view resource/templates/register.html
	}
	*/
	
	@GetMapping("/home")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/templates/login.html
		return modelAndView;
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/templates/admin.html
		return modelAndView;
	}
	

}
