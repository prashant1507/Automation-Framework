package org.automation.utils;

import org.automation.driver.DriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class returns the browser name and version
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 10, 2021
 * @author User1
 * @version 1.0
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BrowserDetails {
	
	public static String browserName() {
		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return capatilize(cap.getBrowserName());
	}
	
	static String browserVersion() {
		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return cap.getVersion();
	}
	
	public static String browserDeatils() {
		return browserName() + " " + browserVersion();
	}
	
	static String capatilize(String text) {
		String firstLetter = text.substring(0, 1);
	    String remainingLetters = text.substring(1, text.length());
	    firstLetter = firstLetter.toUpperCase();
	    remainingLetters = remainingLetters.toLowerCase();
	    text = firstLetter + remainingLetters;
		return text;
	}
}
