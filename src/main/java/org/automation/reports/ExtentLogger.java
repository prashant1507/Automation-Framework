package org.automation.reports;

import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;
import org.automation.utils.PropertyUtils;
import org.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

/**
 * This class adds the status of test step. <br>
 * Creating screenshot and attaching to report in Base64Encoding.
 *
 * <br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 8, 2021
 * 
 * @author User1
 * @version 1.0
 *
 */
public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String msg) {
		if (PropertyUtils.get(ConfigProperties.PASSEDSCREENSHOT).equalsIgnoreCase(FrameworkConstants.getYes()))
			ExtentManager.getExtentTest().pass(msg,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			ExtentManager.getExtentTest().pass(msg);

	}

	public static void fail(String msg) {
		if (PropertyUtils.get(ConfigProperties.FAILEDSCREENSHOT).equalsIgnoreCase(FrameworkConstants.getYes()))
			ExtentManager.getExtentTest().fail(msg,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			ExtentManager.getExtentTest().fail(msg);

	}

	public static void skip(String msg) {
		if (PropertyUtils.get(ConfigProperties.SKIPPEDSCREENSHOT).equalsIgnoreCase(FrameworkConstants.getYes()))
			ExtentManager.getExtentTest().skip(msg,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			ExtentManager.getExtentTest().skip(msg);

	}
}
