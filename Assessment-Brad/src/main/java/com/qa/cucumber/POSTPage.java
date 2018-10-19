package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POSTPage {

	@FindBy(linkText = "//*[@id=\"yui-gen1-button\"]")
	private WebElement retryButton;
	
	public void clickButton() {
		retryButton.click();
	}
}
