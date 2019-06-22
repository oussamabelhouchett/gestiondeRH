package com.pfe;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.sun.faces.config.ConfigureListener;
import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class JsfConfig extends SpringBootServletInitializer implements ServletContextAware {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
            System.out.println("configeration");
		super.onStartup(servletContext);
		
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "0");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
        }

	@Bean
	public ServletRegistrationBean facesServlet() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet, "*.xhtml");
		registration.setName("FacesServlet");
               
		registration.setLoadOnStartup(1);
                 registration.setMultipartConfig(new
                MultipartConfigElement((String) null));
		return registration;
	}
   
@Bean
public FilterRegistrationBean FileUploadFilter() {
       System.out.println("configerationbean");
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new org.primefaces.webapp.filter.FileUploadFilter());
    registration.setName("PrimeFaces FileUpload Filter");

        registration.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.REQUEST);
      
    return registration;
}
	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}
}
