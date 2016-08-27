package com.ttnd.reap.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.service.MyBadgesService;

@Controller
@RequestMapping("/badges")
public class BadgesController {

	@Autowired
	private MyBadgesService myBadgesService;

	@RequestMapping(value = "/{key}/{empEmailid}", method = RequestMethod.GET)
	public ModelAndView AllBadges(@PathVariable String key, @PathVariable String empEmailid, ModelMap modelMap,
			HttpSession session) {

		EmployeeDTO employeeDTO = (EmployeeDTO) session.getAttribute("employee");
		if (employeeDTO != null) {
			List<KarmaReasonDTO> AllBadgeslist = myBadgesService.getAllBadges(employeeDTO);
			List<KarmaReasonDTO> SharedBadgeslist = myBadgesService.getSharedBadges(employeeDTO);
			List<KarmaReasonDTO> ReceivedBadgeslist = myBadgesService.getReceivedBadges(employeeDTO);
			if (key.equalsIgnoreCase("All")) {
				modelMap.addAttribute("Badges", AllBadgeslist);
			} else if (key.equalsIgnoreCase("Received")) {
				modelMap.addAttribute("Badges", ReceivedBadgeslist);
			} else {
				modelMap.addAttribute("Badges", SharedBadgeslist);
			}
			modelMap.addAttribute("AlllistSize", AllBadgeslist.size());
			modelMap.addAttribute("SharedlistSize", SharedBadgeslist.size());
			modelMap.addAttribute("ReceivedlistSize", ReceivedBadgeslist.size());
			modelMap.addAttribute("employee", employeeDTO);
			modelMap.addAttribute("earningKitty", session.getAttribute("earningKitty"));
		} else {
			return new ModelAndView("redirect:/login", "getLoginCredentials", new LoginDTO());
		}
		return new ModelAndView("badge");
	}

}
