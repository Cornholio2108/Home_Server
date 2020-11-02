package com.home_server;

import java.util.HashMap;
import java.util.Map;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration(value = "MyWebConfig")
@EnableScheduling
@EnableAutoConfiguration
public class WebConfig implements ServletContextInitializer {
	@Bean(name = "MyCustomScope")
	public CustomScopeConfigurer customScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		Map<String, Object> scopes = new HashMap<String, Object>();
		scopes.put("view", new ViewScope());
		configurer.setScopes(scopes);

		return configurer;
	}

	@Bean(name = "MyFacesServletRegistration")
	public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
		ServletRegistrationBean<FacesServlet> registrationBean = new ServletRegistrationBean<>(new FacesServlet(),
				"*.xhtml");
		registrationBean.setName("Faces Servlet");
		registrationBean.setLoadOnStartup(1);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<FileUploadFilter> FileUploadFilter() {
		FilterRegistrationBean<FileUploadFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new FileUploadFilter());
		registration.setName("PrimeFaces FileUpload Filter");
		return registration;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("javax.faces.VALIDATE_EMPTY_FIELDS", "true");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
		servletContext.setInitParameter("primefaces.THEME", "#{empty cookie['theme.component'].value ?"
				+ " (empty systemInfo.displayOption.themeComponent ? 'nova-light' : systemInfo.displayOption.themeComponent)"
				+ " : cookie['theme.component'].value}");
		servletContext.setInitParameter("primefaces.UPLOADER", "commons"); // native/commons/auto
		servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
		servletContext.getSessionCookieConfig().setPath(servletContext.getContextPath());
		servletContext.setInitParameter("javax.faces.validator.ENABLE_VALIDATE_WHOLE_BEAN", "true");
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
	}
}
