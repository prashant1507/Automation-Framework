package org.automation.tests;

import org.automation.constants.FrameworkConstants;
import org.automation.driver.Driver;
import org.automation.media.ScreenshotPath;
import org.automation.media.VideoPath;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
 * Before and After methods
 */
public class BaseSetup {

	protected BaseSetup() {
	}

	@BeforeMethod
	protected void setUp(ITestContext context) {
		String browser = context.getCurrentXmlTest().getParameter(FrameworkConstants.getBrowser());
		try {
			Driver.initDriver(browser);
			ScreenshotPath.setCurrentTestExecutionScreenshotsDir();
			VideoPath.setVideoPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	protected void tearDown() {
		try {
		} finally {
			Driver.quiteDriver();
			ScreenshotPath.unloadDir();
			VideoPath.flushVideoPath();
		}
	}
}