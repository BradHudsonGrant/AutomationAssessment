package com.qa.cucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	public WebDriver driver = null;
	ExtentTest test1;
	ExtentTest test2;
	ExtentTest test3;
	ExtentTest test4;
	
	Constants constant = new Constants();
	ExtentReports extent = new ExtentReports(Constants.report, true);

	@After
	public void teardown() {
		driver.close();
		extent.flush();
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriverTarget);
		driver = new ChromeDriver();
	}

	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		driver.get(Constants.url1);
		test1 = extent.startTest("Scenario 1 - Add a User to the database");
		test1.log(LogStatus.INFO, "Browser Started");
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		//POSTPage testing = PageFactory.initElements(driver, POSTPage.class);
		//testing.clickButton();
		AddUserPage addUser = PageFactory.initElements(driver, AddUserPage.class);
		addUser.enterDetails();
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		AddUserPage addUser = PageFactory.initElements(driver, AddUserPage.class);
		addUser.sumbitDetails();
		Thread.sleep(1000);
		test1.log(LogStatus.INFO, "Submitted Form");
		AdminLoginPage adminLogin = PageFactory.initElements(driver,
		AdminLoginPage.class);
		adminLogin.adminlogin();
//		adminLogin.submitLogin();
		test1.log(LogStatus.INFO, "Admin Details Entered And Submitted");
		adminLogin.postButtonClick();
		Thread.sleep(1000);
		addUser.submittyAgainy();
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		Thread.sleep(1000);
		UserListPage usersPage = PageFactory.initElements(driver, UserListPage.class);
		assertEquals("Username does not appear on screen", true, usersPage.userDisplayed());

		System.out.println(driver.getCurrentUrl());
		if (usersPage.userDisplayed()) {
			test1.log(LogStatus.PASS, "Username Visible");
		} else {
			test1.log(LogStatus.FAIL, "Username Not Visible");
		}

	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(
		String arg1, String arg2, String arg3, String arg4) throws Throwable {
		AddUserPage addUser = PageFactory.initElements(driver, AddUserPage.class);
		addUser.submittyAgainy(arg1, arg2, arg3, arg4);
		test2.log(LogStatus.INFO, "Submitted Form");
		AdminLoginPage adminLogin = PageFactory.initElements(driver,
		AdminLoginPage.class);
		adminLogin.adminlogin();
//		adminLogin.submitLogin();
		test2.log(LogStatus.INFO, "Admin Details Entered And Submitted");
		adminLogin.postButtonClick();
		addUser.submittyAgainy(arg1, arg2, arg3, arg4);

	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		UserListPage usersPage = PageFactory.initElements(driver, UserListPage.class);
		assertEquals("Username does not appear on screen", true, usersPage.userDisplayedParam(driver, arg1));

		if (usersPage.userDisplayedParam(driver, arg1)) {
			test2.log(LogStatus.PASS, "Username Visible");
		} else {
			test2.log(LogStatus.FAIL, "Username Not Visible");
		}

	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		driver.get(constant.url3);
		AdminLoginPage adminLogin = PageFactory.initElements(driver,AdminLoginPage.class);
		adminLogin.adminlogin();
		UserListPage usersPage = PageFactory.initElements(driver, UserListPage.class);
		assertEquals("Username Is Not Visible", true, usersPage.userDisplayedParam(driver, arg1));
		test3 = extent.startTest("Scenario 2 - Add a User to the database (Parameters)");
		test3.log(LogStatus.INFO, "Browser Started");
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		UserListPage usersPage = PageFactory.initElements(driver, UserListPage.class);
		usersPage.clickChosenUser(driver, arg1);
		test3.log(LogStatus.INFO, "Username Clicked");

	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		UserProfilePage profile = PageFactory.initElements(driver, UserProfilePage.class);
		assertEquals("Invalid Login", true, profile.lookForUsername(driver, arg1));
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		driver.get("http://localhost:8080/");
		AdminLoginPage adminLogin = PageFactory.initElements(driver,AdminLoginPage.class);
		adminLogin.adminlogin();
		driver.get(constant.url4 + arg1.toLowerCase());
		test3 = extent.startTest("Scenario 3 - View the details of a User on a database");
		test3.log(LogStatus.INFO, "Browser Started");
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		Thread.sleep(1000);
		UserProfilePage profile = PageFactory.initElements(driver, UserProfilePage.class);
		profile.clickConfig();
		test4 = extent.startTest("Scenario 4 - Updating the FullName of a User");
		test4.log(LogStatus.INFO, "Configure Button Click");
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
		ConfigureUserPage config = PageFactory.initElements(driver, ConfigureUserPage.class);
		config.changeName(arg1);
		test4.log(LogStatus.INFO, "Name Change Entered");
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		ConfigureUserPage config = PageFactory.initElements(driver, ConfigureUserPage.class);
		config.clickApply();
		test4.log(LogStatus.INFO, "Saving Changesd");
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		ConfigureUserPage config = PageFactory.initElements(driver, ConfigureUserPage.class);
		assertEquals("Name Does Not Match", arg1, config.checkName());
		if (config.checkName().equals(arg1)) {
			test4.log(LogStatus.PASS, "Successfully changed name");
		} else {
			test4.log(LogStatus.FAIL, "Changing Name Unsuccessfull");
		}
	}

}
