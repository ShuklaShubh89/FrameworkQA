package com.sapient.assignmentqa.framework;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ChromeDriverManager implements DriverManager {

    private ChromeDriverService chService;
    private WebDriver driver;
    private EventFiringWebDriver eDriver;
    
    public void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("resources/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    
    public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.setAcceptInsecureCerts(false);
        driver = new ChromeDriver(options);
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

}
