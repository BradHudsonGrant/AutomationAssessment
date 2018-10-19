package com.qa.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage {

	@FindBy(linkText = "//*[@id=\"main-panel\"]/h1/text()")
	private WebElement userNameLabel;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configButton;
	
	

	public boolean lookForUsername(WebDriver driver, String username){
		WebElement test = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]"));
		String text = test.getText();
		return text.contains(username);
	}
	
	public void clickConfig() {
		configButton.click();
	}
}
