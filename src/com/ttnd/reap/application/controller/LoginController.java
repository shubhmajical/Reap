package com.ttnd.reap.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.dto.ChangeUserRoleDto;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.service.DashboardService;
import com.ttnd.reap.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService UserService;
	
	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(value = { "/", "login", "/loginValidate" }, method = RequestMethod.GET)
	public ModelAndView showlogin(HttpSession session,ModelMap modelMap) {
		modelMap.addAttribute("karma",dashboardService.getWallOfTheFame());
		
		if (session.getAttribute("employee") != null) {
			
			return new ModelAndView("redirect:/index", "sendKarma", new KarmaReasonDTO());
		} else {
			
			return new ModelAndView("login", "getLoginCredentials", new LoginDTO());
		}

	}

	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
	public ModelAndView ValidateLogin(@ModelAttribute LoginDTO loginCredentials, ModelMap modelMap,
			HttpSession session) {

		ModelAndView modelAndView;
		EmployeeDTO employee = UserService.authenticateUser(loginCredentials);
		if (employee != null) {

			if (employee.getRole().equals("Admin")) {

				session.setAttribute("employee", employee);
				modelAndView = new ModelAndView("redirect:/admin", "changeUserRole", new ChangeUserRoleDto());

			} else {

				session.setAttribute("employee", employee);
				modelAndView = new ModelAndView("redirect:/index", "sendKarma", new KarmaReasonDTO());

			}

		} else {
			
			modelMap.addAttribute("msg","Invalid Credentials");
			modelAndView = new ModelAndView("redirect:/login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		if (session.getAttribute("employee") != null) {
			session.invalidate();
		}
		return new ModelAndView("redirect:/index", "sendKarma", new KarmaReasonDTO());
	}

}
