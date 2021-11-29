package org.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends BasePage {

	@FindBy(xpath = "//div[@id='divLogo']/img")
	private By pageLogoImg;

	@FindBy(id = "txtUsername")
	private By usernameTextBox;

	@FindBy(id = "txtPassword")
	private By passwordTextBox;

	@FindBy(xpath = "//input[@id='btnLogin']")
	private By loginBtn;

	@FindBy(xpath = "//div[@id='forgotPasswordLink']/a")
	private By forgotPasswordLink;

	@FindBy(xpath = "//span[@id='spanMessage']")
	private By invalidCredentialsErrorMsg;

	public boolean isPageLogoImgDisplayed() {
		return isDisplayed(pageLogoImg);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return isDisplayed(forgotPasswordLink);
	}

	public void enterUsername(String username) {
		sendKeys(usernameTextBox, username, "Username");
	}

	public void enterPassword(String password) {
		sendKeys(passwordTextBox, password, "Password");
	}

	public void clickLoginBtn() {
		click(loginBtn, "Login button");
	}
	
	public String getInvalidCredentialsErrorMsg() {
		return getText(invalidCredentialsErrorMsg, "Invalid credential error message");
	}
}
