package org.automation.factories;

import org.automation.constants.FrameworkConstants;
import org.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Managing different explicit wait and returning webElement.
 * 
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 8, 2021
 * @author User1
 * @version 1.0
 *
 */
public final class ExplicitWaitFactory {

	/**
	 * 
	 * Private constructor to avoid external instantiation.
	 * <br>
	 * Apr 8, 2021
	 */
	private ExplicitWaitFactory() {
	}

	/**
	 * Explicit wait for element to be clickable.
	 * <br>
	 * Apr 8, 2021
	 * @param by to locate web elements
	 * @return WebElement
	 *
	 */
	public static WebElement explicitWaitForElementToBeClickable(By by) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
				.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Explicit wait for element to be present.
	 * <br>
	 * Apr 8, 2021
	 * @param by to locate web elements
	 * @return WebElement
	 *
	 */
	public static WebElement explicitWaitForElementToBePresent(By by) {
		return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}
}