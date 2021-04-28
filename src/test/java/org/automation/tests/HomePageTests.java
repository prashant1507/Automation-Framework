package org.automation.tests;

import org.automation.dataproviders.DataProviders;
import org.automation.listeners.RetryFailedTests;
import org.automation.pages.HomePage;
import org.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public final class HomePageTests extends BaseSetup {

	private HomePageTests() {
	}

	@Test(testName = "Verify page title", description = "Verify the page tiltle of Login Page")
	public void verifyPageTitle() {
		HomePage homePage = new HomePage();
		Assert.assertEquals(homePage.getPageTitle(), "OrangeHRM", "Title is not matching.");
	}
	
	@Test(testName = "Login page verification fail test", description = "Verify if login page is displayed fail", retryAnalyzer = RetryFailedTests.class)
	public void verifyLoginPage() {
		LoginPage loginPage = new LoginPage();
		Assert.assertEquals(loginPage.isForgotPasswordLinkDisplayed(), false, "Forgot Password link is not displayed.");
	}
	
	@Test(testName = "Skip test name homepage", description = "Skip test case homepage")
	public void skip() {
		throw new SkipException("hi, I am skipped");
	}

	@Test(testName = "Valid login details fail test", dataProvider = "ValidLoginCreds", dataProviderClass = DataProviders.class, description = "Verify if user is able to login using valid credentials fail")
	public void verifyLogin(String username, String password) {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		// Using explicit wait in clickLoginBtn method
		loginPage.clickLoginBtn();
		Assert.assertEquals(homePage.getWelcomeText("Welcome"), false, "Failed to login.");
	}

	@Test(testName = "Verify invalid login details fail test", dataProvider = "InvalidLoginCreds", dataProviderClass = DataProviders.class, description = "Verify if user is not able to login using invalid credentials fail")
	public void verifyInvalidLogin(String username, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		// Using explicit wait in clickLoginBtn method
		loginPage.clickLoginBtn();
		Assert.assertEquals(loginPage.getInvalidCredentialsErrorMsg(), "Invalid credentials", "Failed to login.");
	}
}
