package com.qa.cucumber;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {

	@FindBy (xpath = "//*[@id=\"username\"]")
	private WebElement usernameBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPassBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullNameBox;
	
	@FindBy (xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement emailBox;
	
	@FindBy (xpath = "//*[@id=\"yui-gen1-button\"]")
	private static WebElement form;
	
	@FindBy (name ="username")
	private WebElement a;
	
	@FindBy (name = "password1")
	private WebElement b;
	
	@FindBy (name = "password2")
	private WebElement c;
	
	@FindBy (name ="fullname")
	private WebElement d;
	
	
	public void enterDetails() {
		usernameBox.sendKeys("testing4lyf");
		passBox.sendKeys("testing123");
		confirmPassBox.sendKeys("testing123");
		fullNameBox.sendKeys("Brad");
		fullNameBox.submit();
//		fullNameBox.sendKeys(Keys.ENTER);
//		emailBox.sendKeys("test@googlemail.com");
	}
	
	public void enterDetailsParam(String username, String password, String confirm, String fullname) {
		usernameBox.sendKeys(username);
		passBox.sendKeys(password);
		confirmPassBox.sendKeys(confirm);
		fullNameBox.sendKeys(fullname);
		emailBox.sendKeys("test@googlemail.com");
	}
	public void sumbitDetails() {
//		form.click();
	}
	
	public void submittyAgainy() {
		a.sendKeys("testing4lyf");
		b.sendKeys("testing123");
		c.sendKeys("testing123");
		d.sendKeys("Brad");
		d.submit();
	}
	
	public void submittyAgainy(String username, String password, String confirm, String fullname) {
		a.sendKeys(username);
		b.sendKeys(password);
		c.sendKeys(confirm);
		d.sendKeys(fullname);
		d.submit();
	}
	
}
