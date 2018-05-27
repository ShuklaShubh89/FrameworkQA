package com.sapient.assignmentqa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.inject.Inject;

public class SelectFlightPage extends FlightPage {

	private WebDriver Driver;

	@Inject
	public SelectFlightPage(EventFiringWebDriver driver) {
		super(driver);
		this.Driver = driver;
	}

	private static final By tableHeader = By.cssSelector("td[class='frame_header_info']");
	private static final By priceElements = By.cssSelector("td[class='data_verb_xcols'] font b");

	@SuppressWarnings("null")
	public boolean checkSortedPrice() {
		List<WebElement> price = Driver.findElements(priceElements);
		List<Integer> priceint = null;
		for (int i = 0; i < 4; i++) {
			String temp = price.get(i).getText();
			priceint.add(Integer.parseInt(temp.substring(7, temp.length())));
		}
		List<Integer> tmp = new ArrayList<Integer>(priceint);
		Collections.sort(tmp);
		return tmp.equals(priceint);
	}

	public boolean checkBGcolor() {
		return Driver.findElement(tableHeader).getCssValue("bgcolor").equals("#003399");
	}
}
