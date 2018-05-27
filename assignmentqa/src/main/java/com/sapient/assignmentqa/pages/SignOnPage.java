package com.sapient.assignmentqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.inject.Inject;

public class SignOnPage extends HomePage {

	private WebDriver Driver;

	@Inject
	public SignOnPage(EventFiringWebDriver driver) {
		super(driver);
		this.Driver = driver;
	}

	private static final By welcomeBackSection = By.cssSelector("table[width='492'] img");

	public WebElement getWelcomeSection() {
		return Driver.findElement(welcomeBackSection);
	}

}
