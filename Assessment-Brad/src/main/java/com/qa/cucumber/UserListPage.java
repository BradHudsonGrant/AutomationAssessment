package com.qa.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListPage {

	@FindBy(linkText = "testing4lyf")
	private WebElement userLink;
		
	private WebElement chosenUser;
	
	public boolean userDisplayed() {
		return userLink.isDisplayed();
	}
	
	public void clickChosenUser(WebDriver driver, String username){
		chosenUser = driver.findElement(By.linkText(username));
		chosenUser.click();
	}
	
	public boolean userDisplayedParam(WebDriver driver, String username) {
		chosenUser = driver.findElement(By.linkText(username));
		return chosenUser.isDisplayed();
	}
}