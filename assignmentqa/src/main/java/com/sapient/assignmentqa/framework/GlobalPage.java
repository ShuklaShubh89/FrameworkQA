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
	protected WebDriverWait wait;

	@Inject
	public GlobalPage(EventFiringWebDriver driver) {
		this.Driver = driver;
	}

	public void waitForElementVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOf(Driver.findElement(by)));
	}

	public void waitForElementInvisibility(By by) {
		wait.until(ExpectedConditions.invisibilityOf(Driver.findElement(by)));
	}

	public void waitForElementDOMPresence(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForElementDOMAbsence(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForClickableElement(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForRefreshedPresence(By by) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
	}
	
	public void waitForRefreshedAbsence(By by) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(by)));
	}
	
	public void waitforElementStateSelected(By by) {
		wait.until(ExpectedConditions.elementSelectionStateToBe(by, true));
	}
	
	public void waitforElementStateDeSelected(By by) {
		wait.until(ExpectedConditions.elementSelectionStateToBe(by, false));
	}
	
}
