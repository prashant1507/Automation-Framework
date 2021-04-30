package org.automation.driver;


import org.openqa.selenium.WebDriver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class is responsible in setting and getting the web driver instance.
 * <br>This is done for Thread safety.
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 8, 2021
 * @author User1
 * @version 1.0
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/**
	 * Get web driver instance
	 * <br>
	 * Apr 8, 2021
	 * @return WebDriver
	 *
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * Setup the web driver
	 * <br>
	 * Apr 8, 2021
	 * @param driverRef instance variable for ThreadLocal of type WebDriver.
	 *
	 */
	static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}

	/**
	 * Removes the web driver instance after execution.
	 * <br>
	 * Apr 8, 2021
	 *
	 */
	static void unload() {
		driver.remove();
	}
}
