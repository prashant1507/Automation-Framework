package org.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.automation.constants.FrameworkConstants;
import org.automation.driver.DriverManager;
import org.automation.media.ScreenshotPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

/**
 * This class is to take screenshot for each test steps
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 26, 2021
 * @author User1
 * @version 1.0
 *
 */
public final class ScreenshotUtils {
	/**
	 * Private constructor to avoid external instantiation
	 * <br>
	 * Apr 26, 2021
	 */
	private ScreenshotUtils() {
	}
	
	/**
	 * This function will return image as Base64 and will save image as png for creating video.
	 * <br>
	 * Apr 26, 2021
	 * @param
	 *
	 */
	public static String getBase64Image() {
		getImageAsFile(ScreenshotPath.getCurrentTestExecutionScreenshotsDir());
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	/**
	 * This function will save screenshot as png format
	 * <br>
	 * Apr 26, 2021
	 * @param dir folder where screenshots for current test are stored
	 *
	 */
	static void getImageAsFile(String dir) {
		String screenShotName = dir + "/screenshot_" + new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date()) + ".jpeg";
		TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
		try {
			FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(screenShotName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}
}
