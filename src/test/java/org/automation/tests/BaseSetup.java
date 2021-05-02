package org.automation.tests;

import org.automation.constants.GlobalVars;
import org.automation.driver.Driver;
import org.automation.setpath.ScreenshotPath;
import org.automation.setpath.VideoPath;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/*
 * Before and After methods
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseSetup {

	@BeforeMethod
	protected void setUp(ITestContext context) {
		String browser = context.getCurrentXmlTest().getParameter(GlobalVars.getBrowser());
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
		Driver.quiteDriver();
		ScreenshotPath.unloadDir();
		VideoPath.flushVideoPath();
	}
}