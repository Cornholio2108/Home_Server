package com.home_server;

import java.util.Collections;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.home_server.application.user.UserService;
import com.home_server.domain.user.User;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

	@Resource
	private UserService userService;

	@Value("${Application.name}")
	private String applicationName;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		logger.info("Checking application initial data...");

		// create admin user if not already exist in the system
//		com.home_server.domain.user.User adminUser = userService.getSystemAdminUser().getDataObject();

//		if(adminUser != null) {
//			logger.info("System Admin user already exists");
//		}
//		else {
//			logger.info("System Admin user does not exist, creating....");
//			adminUser = createAdminUser();
//			ServiceResponse<Void> response = userService.addUser(adminUser);
//			
//			if(response.getAckCode() != AckCodeType.SUCCESS) {
//				logger.error("System Admin user does not exist but unable to create one");
//				for(String msg : response.getMessages()) {
//					logger.error(msg);
//				}
//			}
//			else {
//				logger.info("System Admin user created successfully. Creating Announcements forum and Welcome discussion");
//				Forum announcementsForum = createAnouncementsForum(adminUser);
//				createWelcomeDiscussion(announcementsForum, adminUser);
//			}
//		}
	}

	private com.home_server.domain.user.User createAdminUser() {
		User admin = new User();

		admin.setUserName("admin");
		admin.setPassword("secret");

		admin.setFirstName("System");
		admin.setLastName("Admin");
		admin.seteMail("admin@updateme.net");

		return admin;
	}
}
