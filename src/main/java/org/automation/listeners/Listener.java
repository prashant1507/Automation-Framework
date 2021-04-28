package org.automation.listeners;

import java.util.Arrays;
import java.util.Base64;
import org.automation.constants.FrameworkConstants;
import org.automation.elk.ELKUtils;
import org.automation.enums.ConfigProperties;
import org.automation.reports.ExtentLogger;
import org.automation.reports.ExtentManager;
import org.automation.reports.ExtentReport;
import org.automation.testrecorder.TestRecording;
import org.automation.utils.BrowserDetails;
import org.automation.utils.DirectoryCreator;
import org.automation.utils.PropertyUtils;
import org.automation.utils.DeleteFileAndFolders;
import org.automation.utils.UserInputCheck;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

/**
 * To set various methods for handling test cases
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
public class Listener implements ITestListener, ISuiteListener {

	/**
	 * 
	 * Checks if the password for email is in Base64encoded <br>
	 * Apr 8, 2021
	 */
	public void onStart(ISuite suite) {
		try {
			if (PropertyUtils.get(ConfigProperties.SENDMAILAFTEREXECUTION)
					.equalsIgnoreCase(FrameworkConstants.getYes())) {
				Base64.getDecoder().decode(PropertyUtils.get(ConfigProperties.EMAILPASSWORD));
			}
		} catch (Exception e) {
			UserInputCheck.designerOutputForPasswordError();
			System.exit(0);
		}
		DeleteFileAndFolders.deleteOldReports();
		DeleteFileAndFolders.cleanScreenshotsDir();
		ExtentReport.initReports();
	}

	public void onFinish(ISuite suite) {
		ExtentReport.flushReport();
		UserInputCheck.sendTestReportOnEmail();
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTests(result.getMethod().getDescription());
		DirectoryCreator.createRequiredDirs();
	}

	public void onTestSuccess(ITestResult result) {
		ExtentManager.getExtentTest().assignCategory(BrowserDetails.browserDeatils());
		ExtentLogger.pass("Testcase: "
				+ (result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName())
				+ "<br/>" + (result.getClass()).toString().replace("class", "Class: ") + "<br/>" + "Method: "
				+ result.getMethod().getMethodName() + "<br/> Status: Pass");
		ELKUtils.sendDetailsToELK(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName(), "Pass");
	}

	/** 
	 * Record video in case of test fail. <br>
	 * Apr 8, 2021
	 */
	public void onTestFailure(ITestResult result) {
		ExtentManager.getExtentTest().assignCategory(BrowserDetails.browserDeatils());
		ExtentLogger.fail(result.getThrowable().toString() + "<br/><br/>"
				+ Arrays.toString(result.getThrowable().getStackTrace()));
		ExtentLogger.fail("Testcase: "
				+ (result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName())
				+ "<br/>" + (result.getClass()).toString().replace("class", "Class: ") + "<br/>" + "Method: "
				+ result.getMethod().getMethodName() + "<br/> Status: Fail<br/>");

		ExtentLogger.info("<video width='620' height='340' controls> <source src='" + TestRecording.getRecording()
				+ "' type='video/mp4'> <videos>");
		ELKUtils.sendDetailsToELK(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName(), "Fail");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentManager.getExtentTest().assignCategory(BrowserDetails.browserDeatils());
		ExtentLogger.skip("Testcase: "
				+ (result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName())
				+ "<br/>" + (result.getClass()).toString().replace("class", "Class: ") + "<br/>" + "Method: "
				+ result.getMethod().getMethodName() + "<br/> Status: Skip");
		ExtentLogger.info("<video width='620' height='340' controls> <source src='" + TestRecording.getRecording()
				+ "' type='video/mp4'> <videos>");
		ELKUtils.sendDetailsToELK(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName(), "Skip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For future implementation
		 */
	}

	public void onStart(ITestContext context) {
		/*
		 * Invoked after the test class is instantiated and before any configuration
		 * method is called. Currently, there is only one test
		 */
	}

	public void onFinish(ITestContext context) {
		/*
		 * Invoked after all the tests have run and all their Configuration methods have
		 * been called. Currently, there is only one test
		 */
	}

}