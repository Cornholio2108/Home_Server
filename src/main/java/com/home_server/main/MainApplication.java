package com.home_server.main;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.home_server.rest.user.MyRestController;

@SpringBootApplication
@ComponentScan({"com.home_server.rest"})
@EntityScan("com.home_server.domain")
@EnableJpaRepositories("com.home_server.repositories")
public class MainApplication {
//http://localhost:8080/users.xhtml
//spring-boot:run
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		System.out.println("Press 'Enter' to terminate");
		new Scanner(System.in).nextLine();
		System.out.println("Exiting");
		System.exit(1);
	}
}
