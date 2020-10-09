package com.home_server.rest.user;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public RestResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new RestResponse(counter.incrementAndGet(), String.format(template, name));
	}
}
