package com.sapient.assignmentqa.framework;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface DriverManager {

    public void startService();
    public void stopService();
    public void createDriver();
    public void quitDriver();
    public EventFiringWebDriver getDriver();
    
}