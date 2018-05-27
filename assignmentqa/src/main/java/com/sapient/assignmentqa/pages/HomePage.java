package com.sapient.assignmentqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;
import com.sapient.assignmentqa.framework.GlobalPage;

public class HomePage extends GlobalPage {

	private WebDriver Driver;

	@Inject
	public HomePage(EventFiringWebDriver driver) {
		super(driver);
		this.Driver = driver;
	}

	private static final By userName = By.cssSelector("input[name='userName']");
	private static final By passWord = By.cssSelector("input[name='password']");
	private static final By login = By.cssSelector("input[name='login']");
	private static final By dateText = By.cssSelector("table[width='192'] tr[align='right'] td b");

	public void enterUserName(String username) {
		Driver.findElement(userName).sendKeys(username);
	}

	public void enterPassword(String password) {
		Driver.findElement(passWord).sendKeys(password);
	}

	public void clickLogin() {
		Driver.findElement(login).click();
	}

	public boolean getDateOnPage() {
		this.waitForElementDOMPresence(dateText);
		return Driver.findElement(dateText).isDisplayed();
	}

}
