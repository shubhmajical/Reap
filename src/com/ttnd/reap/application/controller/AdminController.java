package com.ttnd.reap.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.dto.BindDTO;
import com.ttnd.reap.dto.ChangeUserRoleDto;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.service.DashboardService;
import com.ttnd.reap.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView showDashBoard(HttpSession session, ModelMap modelMap) {

		ModelAndView modelAndView;

		if (session.getAttribute("employee") == null) {

			return new ModelAndView("redirect:/login", "getLoginCredentials", new LoginDTO());

		} else {

			BindDTO bindData = dashboardService.binddata((EmployeeDTO) session.getAttribute("employee"));
			modelMap.addAttribute("employee", bindData);
			modelAndView = new ModelAndView("admin", "changeUserRole", new ChangeUserRoleDto());
			return modelAndView;
		}

	}

	@RequestMapping(value = "/changeUserRole", method = RequestMethod.POST)
	public ModelAndView ValidateLogin(@ModelAttribute ChangeUserRoleDto changeUserRole, ModelMap modelMap) {

		System.out.println(changeUserRole.getSelectnewer());
		System.out.println(changeUserRole.getChangeRole());
		changeUserRole.setNewer(dashboardService.fetchEmployees(changeUserRole.getSelectnewer()));
		dashboardService.changeUserRole(changeUserRole);

		System.out.println("Role Successfully Changed");

		ModelAndView modelAndView = new ModelAndView("redirect:/admin", "changeUserRole", new ChangeUserRoleDto());

		return modelAndView;
	}

	@RequestMapping(value = "/revokeKarma", method = RequestMethod.POST)
	public ModelAndView revokeKarma(@RequestParam String karmaReason, @RequestParam String revokedKarmaId) {

		System.out.println(karmaReason);

		System.out.println(revokedKarmaId);

		dashboardService.revokeKarma(karmaReason);

		System.out.println("Karma Successfully Revoked");

		ModelAndView modelAndView = new ModelAndView("redirect:/admin", "changeUserRole", new ChangeUserRoleDto());

		return modelAndView;

	}

}
