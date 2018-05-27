package com.sapient.assignmentqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;

public class HomePage {

	private WebDriver Driver;
	
	@Inject
	private WebDriverWait wait;

	@Inject
	public HomePage(EventFiringWebDriver driver) {
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
		;
	}

	public boolean getDateOnPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(dateText));
		return Driver.findElement(dateText).isDisplayed();
	}

}
