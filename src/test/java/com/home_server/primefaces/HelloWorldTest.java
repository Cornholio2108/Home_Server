package com.home_server.primefaces;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.home_server.Globals;
import com.home_server.WebDriverUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HelloWorldTest extends WebDriverUtil {
	@Test
	public void testSubmit() {
//		driver.get("http://localhost:8080/home/test.xhtml");
//
//		HelloWorldPage page = new HelloWorldPage(driver);
//		page.submit("Frankfurt", "Germany");
//		
//		assertThat(page.getGreeting()).contains("Frankfurt am Main");
//		assertThat(Globals.appSettings.getWeatherSettings().getCity().equals("Frankfurt"));
	}
}
