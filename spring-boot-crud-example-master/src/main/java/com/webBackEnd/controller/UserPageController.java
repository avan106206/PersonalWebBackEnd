package com.webBackEnd.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webBackEnd.entity.User;
import com.webBackEnd.service.UserServiceInterfaceImplementation;

@Controller
//@RestController
@RequestMapping(value = {"/user"})
public class UserPageController {
	@Autowired
	UserServiceInterfaceImplementation userServiceInterfaceImplementation;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user"); // resources/templates/login.html
		return modelAndView;
	}
	

}
