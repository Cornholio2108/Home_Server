package com.home_server.primefaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.home_server.PageObject;

public class HelloWorldPage extends PageObject{
	 @FindBy(id = "form_test:test_city")
	  private WebElement cityInput;

	  @FindBy(id = "form_test:test_country")
	  private WebElement countryInput;

	  @FindBy(id = "form_test:test_button")
	  private WebElement testButton;

	  @FindBy(id = "form_test:testOutputPanel")
	  private WebElement testOutput;

	  public HelloWorldPage(WebDriver driver) {
	    super(driver);
	  }

	  public void submit(String firstName, String lastName) {
	    // set the input fields
		  cityInput.clear();
		  cityInput.sendKeys(firstName);
		  countryInput.clear();
		  countryInput.sendKeys(lastName);
		  System.out.println(cityInput.getText());
		  System.out.println(countryInput.getText());
	    // submit the form
//		  testButton.submit();
		  testButton.click();
	    // refresh the output field
	    PageFactory.initElements(driver, this);
	  }

	  public String getGreeting() {
	    return testOutput.getAttribute("textContent");
	  }
}
