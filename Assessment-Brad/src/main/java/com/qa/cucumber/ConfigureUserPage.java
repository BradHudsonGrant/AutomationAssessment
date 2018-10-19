package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigureUserPage {


	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement nameTextBox;
	
	@FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
	private WebElement applyButton;
	
	public void changeName(String username) {
		nameTextBox.clear();
		nameTextBox.sendKeys(username);
	}
	
	public void clickApply() {
		applyButton.click();
	}
	
	public String checkName() {
		return nameTextBox.getAttribute("value");
	}
}
