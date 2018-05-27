package com.sapient.assignmentqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.inject.Inject;

public class BookAFlightPage extends FlightPage {

	private WebDriver Driver;

	@Inject
	public BookAFlightPage(EventFiringWebDriver driver) {
		super(driver);
		this.Driver = driver;
	}

	private static final By firstname = By.cssSelector("input[name='passFirst0']");
	private static final By lastname = By.cssSelector("input[name='passLast0']");
	private static final By creditnumber = By.cssSelector("input[name='creditnumber']");
	private static final By securePurchase = By.cssSelector("input[name='buyFlights']");

	public void enterfirstName(String firstName) {
		Driver.findElement(firstname).sendKeys(firstName);
	}

	public void enterlastName(String lastName) {
		Driver.findElement(lastname).sendKeys(lastName);
	}

	public void enterCreditNumber(String creditNumber) {
		Driver.findElement(creditnumber).sendKeys(creditNumber);
	}

	public void clickSecurePurchase() {
		Driver.findElement(securePurchase).click();
	}

}
