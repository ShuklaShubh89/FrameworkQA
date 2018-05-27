package com.sapient.assignmentqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.Inject;

public class FlightPage extends HomePage {

	private WebDriver Driver;

	@Inject
	public FlightPage(EventFiringWebDriver driver) {
		super(driver);
		this.Driver = driver;
	}

	private static final By departingFrom = By.cssSelector("select[name='fromPort']");
	private static final By arrivingTo = By.cssSelector("select[name='toPort']");
	private static final By economyClass = By.cssSelector("input[value='Coach']");
	private static final By businessClass = By.cssSelector("input[value='Business']");
	private static final By firstClass = By.cssSelector("input[value='First']");
	private static final By continueButton = By.cssSelector("input[name='findFlights']");

	public WebElement getDepartingFrom() {
		return Driver.findElement(departingFrom);
	}

	public void selectDepartingFrom(String citydepart) {
		Select s = new Select(Driver.findElement(departingFrom));
		s.selectByValue(citydepart);
	}

	public void selectArrivingTo(String cityarrive) {
		Select s = new Select(Driver.findElement(arrivingTo));
		s.selectByValue(cityarrive);
	}

	public void selectServiceClass(String serviceClass) {
		if (serviceClass.equals("Economy")) {
			Driver.findElement(economyClass).click();
		} else if (serviceClass.equals("Business")) {
			Driver.findElement(businessClass).click();
		} else if (serviceClass.equals("First")) {
			Driver.findElement(firstClass).click();
		}
	}

	public void clickContinueButton() {
		Driver.findElement(continueButton).click();
	}
}
