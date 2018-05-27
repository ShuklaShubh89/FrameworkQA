package com.sapient.assignmentqa.tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sapient.assignmentqa.framework.DriverModule;
import com.sapient.assignmentqa.pages.FlightPage;

@Guice(modules = {
	    DriverModule.class
	})

public class FlightPageTest {

	@Inject
	WebDriver driver;
	
	@Inject
	FlightPage flightpage;
	
	@Inject
	LoginTest logintest;

	@Inject
    @Named("URL")
    private String URL;
	
	@BeforeMethod
	public void setup() throws IOException {
		driver.get(URL);
		logintest.testValidLogin();
	}

	@Test
	public void FlightDepartingFromTest() {

		int counter = 0;

		Select s = new Select(flightpage.getDepartingFrom());
		List<WebElement> cities = s.getOptions();
		for (WebElement e : cities) {
			if (e.getText().equals("India")) {
				counter++;
				break;
			}
		}
		Assert.assertFalse(counter == 0);

	}

	@Test
	public void FlightReservationTest() {
		flightpage.selectDepartingFrom("India");
		flightpage.selectArrivingTo("London");
		flightpage.selectServiceClass("Economy");
		flightpage.clickContinueButton();
		Assert.assertTrue(driver.getCurrentUrl().contains("mercuryreservation2"));
	}

	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
	}
}
