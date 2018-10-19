package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {

	@FindBy(id = "j_username")
	private WebElement userBox;
	
	@FindBy(name = "j_password")
	private WebElement passBox;
	
	@FindBy(xpath = "/html/body/div/div/form")
	private WebElement form;

	@FindBy(id = "yui-gen1-button")
	private WebElement postButtonThing;
	
	public void adminlogin() {
		userBox.sendKeys("root");
		passBox.sendKeys("root");
		passBox.submit();
	}
	
	public void submitLogin() {
		form.submit();
	}
	
	public void postButtonClick() {
		postButtonThing.click();
	}
}
