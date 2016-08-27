package com.ttnd.reap.application.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;



public class MyWebInitializer  implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
		ServletRegistration.Dynamic registration=servletContext
				.addServlet("DispatcherServlet",new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
	}
}
