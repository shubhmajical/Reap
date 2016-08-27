package com.ttnd.reap.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttnd.reap.dto.*;
import com.ttnd.reap.service.DashboardService;

@Controller
public class AjaxController {
	
	@Autowired
	private DashboardService DashboardService;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<EmployeeDTO> getEmployees(@RequestParam String term,
			HttpServletResponse response,HttpSession session) {
		return DashboardService.searchNewer(term,(EmployeeDTO)session.getAttribute("employee"));
	}

}
