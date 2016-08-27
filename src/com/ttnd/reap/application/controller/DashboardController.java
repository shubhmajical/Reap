package com.ttnd.reap.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.dto.BindDTO;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.service.DashboardService;
import com.ttnd.reap.services.impl.DashboardServiceImpl;

@Controller
public class DashboardController {

	@Autowired
	DashboardService dashboardService;

	@RequestMapping(value = "/karma", method = RequestMethod.POST)
	public ModelAndView karmaReason(@ModelAttribute KarmaReasonDTO sendKarma, ModelMap modelMap) {

		sendKarma.setSenderId(dashboardService.fetchEmployees(sendKarma.getTemporarySenderId()));
		sendKarma.setReceiverId(dashboardService.fetchEmployees(sendKarma.getTemporaryReceiverId()));
			dashboardService.sendKarma(sendKarma);
		System.out.println("updated");
			ModelAndView modelAndView = new ModelAndView("redirect:/index", "sendKarma", new KarmaReasonDTO());

		return modelAndView;

	}
	@RequestMapping(value="/index" ,method=RequestMethod.GET)
	public ModelAndView showDashBoard(HttpSession session,ModelMap  modelMap){
		ModelAndView modelAndView;
		if(session.getAttribute("employee")==null){
			return new ModelAndView("redirect:/login","getLoginCredentials",new LoginDTO());
		}
		else{
			BindDTO bindData=dashboardService.binddata((EmployeeDTO)session.getAttribute("employee"));
			modelMap.addAttribute("employee",bindData);
			session.setAttribute("earningKitty",bindData.getEarningKitty());
			modelAndView=new ModelAndView("index", "sendKarma", new KarmaReasonDTO());
			return modelAndView;
		}	
	}

}
