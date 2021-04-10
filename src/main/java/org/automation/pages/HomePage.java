package org.automation.pages;

import org.automation.factories.BrowserOperationFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class HomePage extends BasePage {
	
	private final By welcomeUserText = By.xpath("//div[@id='branding']/a[@id='welcome']");
	
	public WebElement getWelcomeUser() {
		return getWebElement(welcomeUserText);
	}
	
	public boolean getWelcomeText(String value) {
		return isStringContains(welcomeUserText, value);
	}
	
	public String getPageTitle() {
		return BrowserOperationFactory.getTitle();
	}
}

