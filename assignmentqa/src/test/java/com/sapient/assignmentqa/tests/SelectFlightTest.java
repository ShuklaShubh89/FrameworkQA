package com.sapient.assignmentqa.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sapient.assignmentqa.pages.SelectFlightPage;

public class SelectFlightTest {

	@Inject
	WebDriver driver;
	
	@Inject
	SelectFlightPage selectflightpage;
	
	@Inject
	FlightPageTest flightpagetest;

	@Inject
    @Named("URL")
    private String URL;
	
	@BeforeTest
	public void setup() throws IOException {
		driver.get(URL);
		flightpagetest.FlightReservationTest();
	}

	@Test
	public void bgcolorTest() {
		Assert.assertTrue(selectflightpage.checkBGcolor());
	}

	@Test
	public void checkPriceSortTest() {
		Assert.assertTrue(selectflightpage.checkSortedPrice());
	}
	
}
