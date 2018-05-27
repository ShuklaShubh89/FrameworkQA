package com.sapient.assignmentqa.framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FirefoxDriverManager implements DriverManager {

    private WebDriver driver;
    private EventFiringWebDriver eDriver;
    
    public void createDriver() {
		String currentDir = System.getProperty("user.dir");	
		System.setProperty("webdriver.gecko.driver", currentDir + "resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        options.setAcceptInsecureCerts(false);
        driver = new FirefoxDriver(options);
        eDriver = new EventFiringWebDriver(driver);
   		eDriver.register(new WebEventListener());
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public EventFiringWebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return eDriver;
    }

	public void startService() {
		// TODO Auto-generated method stub
		
	}

	public void stopService() {
		// TODO Auto-generated method stub
		
	}

}