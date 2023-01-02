package com.svg.java.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInitializer implements WebApplicationInitializer{

    // To define the web application
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();       
        // To register the spring's beans
        context.register(SpringConfigurator.class);
        
        // To bind the context or the web application to the configurator
        context.setServletContext(servletContext);
        
        // To load the spring framework servlet, that is in charge of manage the application
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }

    
}
