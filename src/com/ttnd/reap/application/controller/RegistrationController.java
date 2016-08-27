package com.ttnd.reap.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.service.DashboardService;
import com.ttnd.reap.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService UserService;
	

	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	   public ModelAndView registrationPage(HttpSession session,ModelMap modelMap) {	
		modelMap.addAttribute("karma",dashboardService.getWallOfTheFame());
		
	      return new ModelAndView("registration","getRegistrationCredentials",new EmployeeDTO());
	   }   
	
	
	@RequestMapping(value="/registerValidate",method=RequestMethod.POST)
	public ModelAndView getRegistrationCredentials(@ModelAttribute("getRegistrationCredentials") EmployeeDTO registrationCredentials
							,ModelMap modelMap, HttpSession session){
		
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		if(UserService.registerUser(registrationCredentials)){
			modelMap.addAttribute("msg","Successfully Registered");
		}else
		{
			modelMap.addAttribute("msg","Error Occured");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/registerValidate",method=RequestMethod.GET)
	public ModelAndView redirectToLogin(HttpSession session){
		ModelAndView modelAndView = new ModelAndView("redirect:/login","getLoginCredentials",new LoginDTO());
		return modelAndView;
	}
}
