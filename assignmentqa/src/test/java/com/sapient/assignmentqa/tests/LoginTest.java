package com.sapient.assignmentqa.tests;

import java.io.IOException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sapient.assignmentqa.pages.*;
import com.sapient.assignmentqa.framework.DriverModule;

@Guice(modules = { DriverModule.class })

public class LoginTest {

	@Inject
	EventFiringWebDriver driver;

	@Inject
	private HomePage homepage;

	@Inject
	private SignOnPage signonPage;

	@Inject
	@Named("URL")
	private String URL;
	@Inject
	@Named("Username")
	private String UserName;
	@Inject
	@Named("Password")
	private String Password;

	@BeforeMethod
	public void setup() throws IOException {
		driver.get(URL);

	}

	@Test
	public void testLogin() {
		Assert.assertTrue(homepage.getDateOnPage());

	}

	@Test
	public void testWrongLogin() {
		homepage.enterUserName("wrong username");
		homepage.enterPassword("wrong password");
		homepage.clickLogin();
		Assert.assertTrue(signonPage.getWelcomeSection().isDisplayed());
	}

	@Test
	public void testValidLogin() {
		homepage.enterUserName(UserName);
		homepage.enterPassword(Password);
		homepage.clickLogin();
		Assert.assertTrue(driver.getCurrentUrl().contains("mercuryreservation.php"));
	}

	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
	}
}
