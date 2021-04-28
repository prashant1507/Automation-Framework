package org.automation.constants;

/**
 * FrameworkConstants stores all the framework related constants.
 * <br>
 * Class is final to avoid extend.
 * <br><br>
 * Apr 8, 2021
 * @author User1
 * @version 1.0
 *
 */

public final class FrameworkConstants {

	/**
	 * 
	 * Private constructor to avoid external instantiation
	 * <br>
	 * Apr 8, 2021
	 */
	private FrameworkConstants() {
	}

	private static final String USERDIR = System.getProperty("user.dir");
	private static final String OS_PLATFORM = System.getProperty("os.name");
	private static final String OS_VERSION = System.getProperty("os.version");
	private static final String OS_ARCH = System.getProperty("os.arch");

	private static final String RESOURCES_PATH = USERDIR.concat("/src/test/resources/");

	private static final String CHROMEDRIVER_WIN_PATH = RESOURCES_PATH.concat("drivers/windows/chromedriver.exe");
	private static final String CHROMEDRIVER_MACOS_PATH = RESOURCES_PATH.concat("drivers/macOS/chromedriver");
	private static final String CHROMEDRIVER_LINUX_PATH = RESOURCES_PATH.concat("drivers/linux/chromedriver");
	private static final String FIREFOXDRIVER_WIN_PATH = RESOURCES_PATH.concat("drivers/windows/geckodriver.exe");
	private static final String FIREFOXDRIVER_MACOS_PATH = RESOURCES_PATH.concat("drivers/macOS/geckodriver");
	private static final String FIREFOXDRIVER_LINUX_PATH = RESOURCES_PATH.concat("drivers/linux/geckodriver");

	private static final String FRAMEWORK_CONFIG_PROPERTIES_PATH = RESOURCES_PATH
			.concat("config/FrameworkConfig.properties");
	private static final String FRAMEWORK_CONFIG_JSON_PATH = RESOURCES_PATH.concat("config/FrameworkConfig.json");
	private static final String DATAFILE_PATH = RESOURCES_PATH.concat("data/Data.xlsx");
	
	private static final String REPORT_DIR = USERDIR.concat("/test-reports");
	private static final String VIDEO_DIR = USERDIR.concat("/test-report-videos");
	private static final String SCREENSHOT_DIR = USERDIR.concat("/test-screenshots/");
	
	private static final String CHROMEDRIVER = "webdriver.chrome.driver";
	private static final String FIREFOXDRIVER = "webdriver.gecko.driver";
	private static final String CHROME = "Chrome";
	private static final String FIREFOX = "Firefox";
	private static final String BROWSER = "Browser";
	private static final String WINDOWS = "Windows";
	private static final String MACOS = "Mac OS";

	public static final String DATETIME_FORMAT1 = "dd_MM_yyyy_hh_mm_ss_SSS";
	private static final String DATETIME_FORMAT2 = "dd/MM/yyyy HH:mm:ss";
	private static final String UTF8_ENCODING = "UTF-8";
	private static final String REPORT_NAME = "QA Test Report";
	private static final String REPORT_TITLE = "Test Report";
	private static final int EXPLICITWAIT = 10;
	private static final int MAXRETRYCOUNTER = 2;
	private static final String YES = "yes";
	private static final String NO = "no";
	private static final String EXECUTE_PERMISSION = "chmod u+x ";
	private static final String EXECUTION = "Execution";
	private static final String AVI = "avi";
	private static final String MP4 = "mp4";
	private static final String BLACK = "black";
	
	private static final String GRID = "grid";
	private static final String LOCAL = "local";
	private static final String SELENOID = "selenoid";
	
	public static String getBlack() {
		return BLACK;
	}

	public static String getExecution() {
		return EXECUTION;
	}

	public static String getAvi() {
		return AVI;
	}

	public static String getMp4() {
		return MP4;
	}

	public static String getChromeDriverWinPath() {
		return CHROMEDRIVER_WIN_PATH;
	}

	public static String getChromeDriverMacosPath() {
		return CHROMEDRIVER_MACOS_PATH;
	}

	public static String getChromeDriverLinuxPath() {
		return CHROMEDRIVER_LINUX_PATH;
	}

	public static String getFirefoxDriverWinPath() {
		return FIREFOXDRIVER_WIN_PATH;
	}

	public static String getFirefoxDriverMacosPath() {
		return FIREFOXDRIVER_MACOS_PATH;
	}

	public static String getFirefoxDriverLinuxPath() {
		return FIREFOXDRIVER_LINUX_PATH;
	}

	public static String getWindows() {
		return WINDOWS;
	}

	public static String getMacos() {
		return MACOS;
	}

	public static String getFrameworkConfigPathFromPropertiesFile() {
		return FRAMEWORK_CONFIG_PROPERTIES_PATH;
	}

	public static String getFrameworkConfigPathFromJsonFile() {
		return FRAMEWORK_CONFIG_JSON_PATH;
	}

	public static String getReportDir() {
		return REPORT_DIR;
	}
	
	public static String getExecutePermission() {
		return EXECUTE_PERMISSION;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getUserdir() {
		return USERDIR;
	}

	public static String getDateTimeFormat1() {
		return DATETIME_FORMAT1;
	}

	public static String getOsPlatform() {
		return OS_PLATFORM;
	}

	public static String getOsVersion() {
		return OS_VERSION;
	}

	public static String getOsArch() {
		return OS_ARCH;
	}

	public static String getDateTimeFormat2() {
		return DATETIME_FORMAT2;
	}

	public static String getUtf8Encoding() {
		return UTF8_ENCODING;
	}

	public static String getReportName() {
		return REPORT_NAME;
	}

	public static String getReportTitle() {
		return REPORT_TITLE;
	}

	public static String getDataFilePath() {
		return DATAFILE_PATH;
	}

	public static int getMaxRetryCounter() {
		return MAXRETRYCOUNTER;
	}

	public static String getYes() {
		return YES;
	}

	public static String getNo() {
		return NO;
	}

	public static String getChromeDriver() {
		return CHROMEDRIVER;
	}

	public static String getFirefoxDriver() {
		return FIREFOXDRIVER;
	}

	public static String getChrome() {
		return CHROME;
	}

	public static String getFirefox() {
		return FIREFOX;
	}

	public static String getBrowser() {
		return BROWSER;
	}

	public static String getVideoDir() {
		return VIDEO_DIR;
	}
	
	public static String getScreenshotsDir() {
		return SCREENSHOT_DIR;
	}

	public static String getGrid() {
		return GRID;
	}

	public static String getLocal() {
		return LOCAL;
	}

	public static String getSelenoid() {
		return SELENOID;
	}

}
