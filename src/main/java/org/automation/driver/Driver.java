package org.automation.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.automation.constants.GlobalVars;
import org.automation.enums.ConfigMap;
import org.automation.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {
	
	/**
	 * Setup the web driver for browser <br>
	 * Apr 8, 2021
	 * 
	 * @param browser current browser where the test will run.
	 *
	 */
	public static void initDriver(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase(GlobalVars.getChrome())) {
				setChromeDriver();
			} else if (browser.equalsIgnoreCase(GlobalVars.getFirefox())) {
				setFirefoxDriver();
			}
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.get(ConfigMap.URLFORENV));
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
			if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getGrid())) {
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigMap.REMOTEURL)), cap));
			} else if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getLocal())) {
				if (PropertyUtils.get(ConfigMap.DOWNLOADWEBDRIVER)
						.equalsIgnoreCase(GlobalVars.getYes())) {
					WebDriverManager.firefoxdriver().setup();
				} else {
					System.setProperty(GlobalVars.getFirefoxDriver(), setFirefoxDriverPath());
				}
				DriverManager.setDriver(new FirefoxDriver());
			} else if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getSelenoid())) {
				cap.setCapability("enableVNC", true);
				cap.setCapability("enableVideo", true);
				cap.setCapability("videoName",
						"Test_" + (new SimpleDateFormat(GlobalVars.getDateTimeFormat1()).format(new Date())));
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigMap.REMOTEURL)), cap));
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
			if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getGrid())) {
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigMap.REMOTEURL)), cap));
			} else if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getLocal())) {
				if (PropertyUtils.get(ConfigMap.DOWNLOADWEBDRIVER)
						.equalsIgnoreCase(GlobalVars.getYes())) {
					WebDriverManager.chromedriver().setup();
				} else {
					System.setProperty(GlobalVars.getChromeDriver(), setChromeDriverPath());
				}
				DriverManager.setDriver(new ChromeDriver());
			} else if (PropertyUtils.get(ConfigMap.RUNMODE).equalsIgnoreCase(GlobalVars.getSelenoid())) {
				cap.setCapability("enableVNC", true);
				cap.setCapability("enableVideo", true);
				cap.setCapability("videoName",
						"Test_" + (new SimpleDateFormat(GlobalVars.getDateTimeFormat1()).format(new Date())));
				DriverManager
						.setDriver(new RemoteWebDriver(new URL(PropertyUtils.get(ConfigMap.REMOTEURL)), cap));
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
		String os = GlobalVars.getOsPlatform(); 
		String driver = "";
		try {
			if (os.startsWith(GlobalVars.getWin())) {
				driver = GlobalVars.getWinChromeDriverPath();
			} else if (os.startsWith(GlobalVars.getMacOs())) {
				driver = GlobalVars.getMacChromeDriverPath();
				Runtime.getRuntime().exec(GlobalVars.getExecutePermission() + driver);
			} else {
				driver = GlobalVars.getLinuxChromeDriverPath();
				Runtime.getRuntime().exec(GlobalVars.getExecutePermission() + driver);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}

	/**
	 * Setup the Chrome driver based on operating system. <br>
	 * Apr 8, 2021
	 * 
	 * @return String
	 *
	 */
	private static String setFirefoxDriverPath() {
		String os = GlobalVars.getOsPlatform();
		String driver = "";
		try {
			if (os.startsWith(GlobalVars.getWin())) {
				driver = GlobalVars.getWinFirefoxDriverPath();
			} else if (os.startsWith(GlobalVars.getMacOs())) {
				driver = GlobalVars.getMacosFirefoxDriverPath();
				Runtime.getRuntime().exec(GlobalVars.getExecutePermission() + driver);
			} else {
				driver = GlobalVars.getLinuxFirefoxDriverPath();
				Runtime.getRuntime().exec(GlobalVars.getExecutePermission() + driver);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
