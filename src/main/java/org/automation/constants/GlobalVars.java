package org.automation.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GlobalVars {

	@Getter private static String userDir = System.getProperty("user.dir");
	@Getter private static String osPlatform = System.getProperty("os.name");
	@Getter private static String osVersion = System.getProperty("os.version");
	@Getter private static String osArch = System.getProperty("os.arch");

	@Getter private static String resPath = userDir.concat("/src/test/resources/");

	@Getter private static String winChromeDriverPath = resPath.concat("drivers/windows/chromedriver.exe");
	@Getter private static String macChromeDriverPath = resPath.concat("drivers/macOS/chromedriver");
	@Getter private static String linuxChromeDriverPath = resPath.concat("drivers/linux/chromedriver");
	@Getter private static String winFirefoxDriverPath = resPath.concat("drivers/windows/geckodriver.exe");
	@Getter private static String macosFirefoxDriverPath = resPath.concat("drivers/macOS/geckodriver");
	@Getter private static String linuxFirefoxDriverPath = resPath.concat("drivers/linux/geckodriver");

	@Getter private static String configProp = resPath.concat("config/Config.properties");
	@Getter private static String configJson = resPath.concat("config/FrameworkConfig.json");
	@Getter private static String dataFile = resPath.concat("data/Data.xlsx");
	
	@Getter private static String reportDir = userDir.concat("/test-reports");
	@Getter private static String videoDir = userDir.concat("/test-report-videos");
	@Getter private static String screenshotDir = userDir.concat("/test-screenshots/");
	
	@Getter private static String chromeDriver = "webdriver.chrome.driver";
	@Getter private static String firefoxDriver = "webdriver.gecko.driver";
	@Getter private static String chrome = "Chrome";
	@Getter private static String firefox = "Firefox";
	@Getter private static String browser = "Browser";
	@Getter private static String win = "Windows";
	@Getter private static String macOs = "Mac OS";

	@Getter private static String dateTimeFormat1 = "dd_MM_yyyy_hh_mm_ss_SSS";
	@Getter private static String dateTimeFormat2 = "dd/MM/yyyy HH:mm:ss";
	@Getter private static String utf8 = "UTF-8";
	@Getter private static String reportName = "QA Test Report";
	@Getter private static String reportTitle = "Test Report";
	@Getter private static int explicitWait = 10;
	@Getter private static int maxRetryCounter = 2;
	@Getter private static String yes = "yes";
	@Getter private static String no = "no";
	@Getter private static String executePermission = "chmod u+x ";
	@Getter private static String execution = "Execution";
	
	@Getter private static String grid = "grid";
	@Getter private static String local = "local";
	@Getter private static String selenoid = "selenoid";
}
