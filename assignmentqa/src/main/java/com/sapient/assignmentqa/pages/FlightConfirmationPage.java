package com.sapient.assignmentqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

public class FlightConfirmationPage {

	private WebDriver Driver;

	@Inject
	public FlightConfirmationPage(WebDriver driver) {
		this.Driver = driver;
	}

	private static final By confirmationNumber = By.xpath("//font[contains(text(),'Flight Confirmation #')");
	private static final By signOff = By.cssSelector("a[href='mercurysignoff.php']");

	public String getConfirmationNumber() {
		return Driver.findElement(confirmationNumber).getText();
	}

	public void clickSignOff() {
		Driver.findElement(signOff).click();
	}
}
