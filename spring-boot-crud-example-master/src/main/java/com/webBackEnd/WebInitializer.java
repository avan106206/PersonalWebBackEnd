package com.webBackEnd;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer { //to reset the dispatch servlet, run this class to rebuild the whole project.
    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context
          = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.webBackEnd.configuration");
 
        container.addListener(new ContextLoaderListener(context));
 
        ServletRegistration.Dynamic dispatcher = container
          .addServlet("dispatcher", new DispatcherServlet(context));
         
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
