package org.automation.media;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.automation.constants.FrameworkConstants;
import org.automation.utils.BrowserDetails;

/**
 * This class is to set and get screenshot folder path <br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 26, 2021
 * 
 * @author User1
 * @version 1.0
 * 
 */
public final class ScreenshotPath {

	/**
	 * Private constructor to avoid external instantiation <br>
	 * Apr 26, 2021
	 */
	private ScreenshotPath() {
	}

	private static ThreadLocal<String> dir = new ThreadLocal<String>();

	/**
	 * This function clears dir variable for thread safety <br>
	 * Apr 26, 2021
	 *
	 */
	public static void unloadDir() {
		dir.remove();
	}

	/**
	 * This method return current test execution screenshot folder <br>
	 * Apr 26, 2021
	 *
	 */
	public static String getCurrentTestExecutionScreenshotsDir() {
		return dir.get();
	}

	/**
	 * This method sets current test execution screenshot folder <br>
	 * Apr 26, 2021
	 *
	 */
	public static void setCurrentTestExecutionScreenshotsDir() {
		dir.set(FrameworkConstants.getScreenshotsDir() + BrowserDetails.browserName() + "_"
				+ new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date()));
	}
}
