package com.sapient.assignmentqa.framework;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class DriverManagerProvider implements Provider<DriverManager> {

	@Inject
	@Named("Browser")
	private String Browser;
	
	public DriverManager get() {
		if(Browser.equalsIgnoreCase("Chrome")) {
			return new ChromeDriverManager();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			return new FirefoxDriverManager();
		}
		else {
			return new ChromeDriverManager();
		}
	}
	

}
