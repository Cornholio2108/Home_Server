package com.home_server;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
