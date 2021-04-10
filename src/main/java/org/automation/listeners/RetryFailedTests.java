package org.automation.listeners;

import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;
import org.automation.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Listener class to re-run failed test case
 * 
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 8, 2021
 * @author User1
 * @version 1.0
 *
 */
public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = FrameworkConstants.getMaxRetryCounter();

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTCASES).equalsIgnoreCase(FrameworkConstants.getYes())) {
			value = count < retries;
			count++;
		}
		return value;
	}
}
