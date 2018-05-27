package com.sapient.assignmentqa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;

public class GlobalPage {


	private WebDriver Driver;
	
	@Inject
	private WebDriverWait wait;

	@Inject
	public GlobalPage(EventFiringWebDriver driver) {
		this.Driver = driver;
	}
	
	public void waitForVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOf(Driver.findElement(by)));
	}
}
