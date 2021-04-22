package org.automation.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.automation.constants.FrameworkConstants;
import org.automation.enums.ConfigProperties;
import org.automation.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * Setup the web driver and removes it at the end of execution. <br>
 * Class is final to avoid extend. <br>
 * <br>
 * Apr 8, 2021
 * 
 * @author User1
 * @version 1.0
 *
 */
public final class Driver {

	/**
	 * 
	 * Private constructor to avoid external instantiation <br>
	 * Apr 8, 2021
	 */
	private Driver() {
	}

	/**
	 * Setup the web driver for browser <br>
	 * Apr 8, 2021
	 * 
	 * @param browser current browser where the test will run.
	 *
	 */
	public static void initDriver(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase(FrameworkConstants.getChrome())) {
				setChromeDriver();
			} else if (browser.equalsIgnoreCase(FrameworkConstants.getFirefox())) {
				setFirefoxDriver();
			}
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URLFORENV));
		}
	}

	/**
	 * Removes the web driver at the end of execution <br>
	 * Apr 8, 2021
	 *
	 */
	public static void quiteDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

	/**
	 * Sets the firefox driver <br>
	 * Apr 9, 2021
	 *
	 */
	private static void setFirefoxDriver() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.FIREFOX);
		try {
			if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase(FrameworkConstants.getGrid())) {
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), cap));
			} else if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase(FrameworkConstants.getLocal())) {
				if (PropertyUtils.get(ConfigProperties.DOWNLOADWEBDRIVER)
						.equalsIgnoreCase(FrameworkConstants.getYes())) {
					WebDriverManager.firefoxdriver().setup();
				} else {
					System.setProperty(FrameworkConstants.getFirefoxDriver(), setFirefoxDriverPath());
				}
				DriverManager.setDriver(new FirefoxDriver());
			} else if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase(FrameworkConstants.getSelenoid())) {
				cap.setCapability("enableVNC", true);
				cap.setCapability("enableVideo", true);
				cap.setCapability("videoName",
						"Test_" + (new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date())));
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), cap));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the chrome driver <br>
	 * Apr 9, 2021
	 *
	 */
	private static void setChromeDriver() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		try {
			if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase(FrameworkConstants.getGrid())) {
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), cap));
			} else if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase(FrameworkConstants.getLocal())) {
				if (PropertyUtils.get(ConfigProperties.DOWNLOADWEBDRIVER)
						.equalsIgnoreCase(FrameworkConstants.getYes())) {
					WebDriverManager.chromedriver().setup();
				} else {
					System.setProperty(FrameworkConstants.getChromeDriver(), setChromeDriverPath());
				}
				DriverManager.setDriver(new ChromeDriver());
			} else if (PropertyUtils.get(ConfigProperties.RUNMODE).equalsIgnoreCase(FrameworkConstants.getSelenoid())) {
				cap.setCapability("enableVNC", true);
				cap.setCapability("enableVideo", true);
				cap.setCapability("videoName",
						"Test_" + (new SimpleDateFormat(FrameworkConstants.getDateTimeFormat1()).format(new Date())));
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.REMOTEURL)), cap));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setup the Chrome driver based on operating system. <br>
	 * Apr 8, 2021
	 * 
	 * @return String
	 *
	 */
	private static String setChromeDriverPath() {
		String os = FrameworkConstants.getOsPlatform();
		String chromeDriverPath = "";
		try {
			if (os.startsWith(FrameworkConstants.getWindows())) {
				chromeDriverPath = FrameworkConstants.getChromeDriverWinPath();
			} else if (os.startsWith(FrameworkConstants.getMacos())) {
				chromeDriverPath = FrameworkConstants.getChromeDriverMacosPath();
				Runtime.getRuntime().exec(FrameworkConstants.getExecutePermission() + chromeDriverPath);
			} else if (true) {
				chromeDriverPath = FrameworkConstants.getChromeDriverLinuxPath();
				Runtime.getRuntime().exec(FrameworkConstants.getExecutePermission() + chromeDriverPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chromeDriverPath;
	}

	/**
	 * Setup the Chrome driver based on operating system. <br>
	 * Apr 8, 2021
	 * 
	 * @return String
	 *
	 */
	private static String setFirefoxDriverPath() {
		String os = FrameworkConstants.getOsPlatform();
		String firefoxDriverPath = "";
		try {
			if (os.startsWith(FrameworkConstants.getWindows())) {
				firefoxDriverPath = FrameworkConstants.getFirefoxDriverWinPath();
			} else if (os.startsWith(FrameworkConstants.getMacos())) {
				firefoxDriverPath = FrameworkConstants.getFirefoxDriverMacosPath();
				Runtime.getRuntime().exec(FrameworkConstants.getExecutePermission() + firefoxDriverPath);
			} else if (true) {
				firefoxDriverPath = FrameworkConstants.getFirefoxDriverLinuxPath();
				Runtime.getRuntime().exec(FrameworkConstants.getExecutePermission() + firefoxDriverPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return firefoxDriverPath;
	}
}
