package org.automation.constants;

import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * FrameworkConstants stores all the framework related constants.
 * <br>
 * Class is to avoid extend.
 * <br><br>
 * Apr 8, 2021
 * @author User1
 * @version 1.0
 *
 */

@UtilityClass
public class GlobalVars {

	@Getter final String userDir = System.getProperty("user.dir");
	@Getter final String osPlatform = System.getProperty("os.name");
	@Getter final String osVersion = System.getProperty("os.version");
	@Getter final String osArch = System.getProperty("os.arch");

	@Getter final String resPath = userDir.concat("/src/test/resources/");

	@Getter final String winChromeDriverPath = resPath.concat("drivers/windows/chromedriver.exe");
	@Getter final String macChromeDriverPath = resPath.concat("drivers/macOS/chromedriver");
	@Getter final String linuxChromeDriverPath = resPath.concat("drivers/linux/chromedriver");
	@Getter final String winFirefoxDriverPath = resPath.concat("drivers/windows/geckodriver.exe");
	@Getter final String macosFirefoxDriverPath = resPath.concat("drivers/macOS/geckodriver");
	@Getter final String linuxFirefoxDriverPath = resPath.concat("drivers/linux/geckodriver");

	@Getter final String configProp = resPath.concat("config/Config.properties");
	@Getter final String configJson = resPath.concat("config/FrameworkConfig.json");
	@Getter final String dataFile = resPath.concat("data/Data.xlsx");

	@Getter final String reportDir = userDir.concat("/test-reports");
	@Getter final String videoDir = userDir.concat("/test-report-videos");
	@Getter final String screenshotDir = userDir.concat("/test-screenshots/");

	@Getter final String chromeDriver = "webdriver.chrome.driver";
	@Getter final String firefoxDriver = "webdriver.gecko.driver";
	@Getter final String chrome = "Chrome";
	@Getter final String firefox = "Firefox";
	@Getter final String browser = "Browser";
	@Getter final String win = "Windows";
	@Getter final String macOs = "Mac OS";

	@Getter final String dateTimeFormat1 = "dd_MM_yyyy_hh_mm_ss_SSS";
	@Getter final String dateTimeFormat2 = "dd/MM/yyyy HH:mm:ss";
	@Getter final String reportName = "QA Test Report";
	@Getter final String reportTitle = "Test Report";
	@Getter final int explicitWait = 10;
	@Getter final int maxRetryCounter = 2;
	@Getter final String yes = "yes";
	@Getter final String no = "no";
	@Getter final String executePermission = "chmod u+x ";

	@Getter final String grid = "grid";
	@Getter final String local = "local";
	@Getter final String selenoid = "selenoid";
	@Getter final String zalenium = "zalenium";
}
