package com.home_server;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

@Configuration(value = "MyAppConfig")
public class AppConfig {
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Bean(name = "applicationProperties")
	public PropertiesFactoryBean applicationProperties() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setIgnoreResourceNotFound(true);
		try {
			/*
			 * application.properties file priority: ./config/application.properties
			 * ./application.properties classpath:application.properties
			 */
			bean.setLocations(new ClassPathResource("application.properties"),
					new UrlResource("file:./application.properties"),
					new UrlResource("file:./config/application.properties"));
		} catch (MalformedURLException e) {
			logger.error("Unable to load application.properties file:", e);
		}
		return bean;
	}
}
