package com.sapient.assignmentqa.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class DriverModule extends AbstractModule {

	
    @Override
    protected void configure() {

        bind(DriverManager.class)
        .toProvider(DriverManagerProvider.class).in(Scopes.SINGLETON);
       

        Properties props = new Properties();
		try {
			props.load(new FileInputStream("resources/config.properties"));
			Names.bindProperties(binder(), props);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Provides
    public EventFiringWebDriver getDriver(DriverManager driverManager) {
        return driverManager.getDriver();
    }
    
  
    @Provides
    public Actions getActions(EventFiringWebDriver driver) {
        return new Actions(driver);
    }

    @Provides
    public JavascriptExecutor getExecutor(EventFiringWebDriver driver) {
        return (JavascriptExecutor)(driver);
    }

    @Provides
    public WebDriverWait getWait(EventFiringWebDriver driver) {
        return new WebDriverWait(driver,30);
    }
}
